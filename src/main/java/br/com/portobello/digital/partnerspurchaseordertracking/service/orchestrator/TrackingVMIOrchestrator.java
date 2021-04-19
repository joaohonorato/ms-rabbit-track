package br.com.portobello.digital.partnerspurchaseordertracking.service.orchestrator;

import br.com.portobello.digital.commons.exceptions.ApplicationException;
import br.com.portobello.digital.commons.exceptions.ErrorDetail;
import br.com.portobello.digital.commons.exceptions.ErrorPayloadEvent;
import br.com.portobello.digital.commons.headers.HeaderHelper;
import br.com.portobello.digital.commons.log.MessageLog;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.factory.TrackingVMIStockFactory;
import br.com.portobello.digital.partnerspurchaseordertracking.service.broker.vmi.PortOutboundVMI;
import br.com.portobello.digital.partnerspurchaseordertracking.service.tracking.VMIStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Map;

@Service
public class TrackingVMIOrchestrator {

    private Logger logger = LoggerFactory.getLogger(TrackingVMIOrchestrator.class);

    @Autowired
    private PortOutboundVMI portOutbound;

    @Autowired
    private VMIStockService orderService;

    @Autowired
    private TrackingVMIStockFactory factory;

    @Value("${app.rabbitmq.maximumNumberOfRetries:3}")
    private int maximumNumberOfRetries;

    public void processVMIStock(SupplierStockRequestDTO event, @Headers Map<String, Object> headers) {
        if(event == null || event.getPayloadId() == null) {
            logger.warn(MessageLog.builder("Missing payload or payloadId", headers).message("Could not process this event").payload(event).build());
            sendMessageOperationError(event, new ErrorDetail(HttpStatus.BAD_REQUEST, "Could not process this event"), headers);
        }
        var id = event.getPayloadId();
        try {
            orderService.register(factory.createTrackingVMIStock(event));
            portOutbound.sendMessageVMIStockAvailable(event , headers);
            orderService.updatePartnersPurchaseOrderStatus(id, TrackingStatusType.NOTIFIED);
        } catch (ApplicationException e) {
            logger.warn(MessageLog.builder(id, headers).message(e.getMessage()).payload(event).build(), e);
            sendMessageOperationError(event, e.getErrorDetail(), headers);
        } catch (ConstraintViolationException e) {
            logger.warn(MessageLog.builder(id, headers).message(e.getMessage()).payload(event).build(), e);
            sendMessageOperationError(event, new ErrorDetail(HttpStatus.BAD_REQUEST, e.getMessage()), headers);
        } catch (Exception e) {
            logger.error(MessageLog.builder(id, headers).message(e.getMessage()).payload(event).build(), e);
            sendMessageForWait(event, e, headers);
        }
    }

    private void sendMessageOperationError(SupplierStockRequestDTO event, ErrorDetail errosDetail, Map<String, Object> headers) {
        var error = new ErrorPayloadEvent<>(event).addErros(errosDetail);
        portOutbound.sendMessageTrackingVMIStockOperationError(error, event.getPayloadId(), headers);
    }

    private void sendMessageForWait(SupplierStockRequestDTO event, Exception e, Map<String, Object> headers) {
        if (HeaderHelper.getRetryCount(headers) < maximumNumberOfRetries) {
            portOutbound.sendMessageVMIStockSyncRequestedWait(event, event.getPayloadId(), headers);
        } else {
            ErrorDetail detail = new ErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            sendMessageOperationError(event, detail, headers);
        }
    }

}
