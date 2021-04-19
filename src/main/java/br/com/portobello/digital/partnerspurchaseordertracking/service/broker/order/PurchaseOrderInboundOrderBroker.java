package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.order;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.OrderDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.service.broker.config.BrokerInput;
import br.com.portobello.digital.partnerspurchaseordertracking.service.orchestrator.TrackingPurchaseOrderOrchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@EnableBinding(BrokerInput.class)
public class PurchaseOrderInboundOrderBroker implements PortInboundOrder {

	private Logger logger = LoggerFactory.getLogger(PurchaseOrderInboundOrderBroker.class);

	@Autowired
	private TrackingPurchaseOrderOrchestrator orchestrator;

	@Override
	@StreamListener(target = BrokerInput.SUBSCRIBE_EXCHANGE_PARTNERS_PURCHASE_ORDER_REQUESTED)
	public void subscribeExchangePartnersPurchaseOrderRequested(OrderDTO order, @Headers Map<String, Object> headers) {
		logger.info("Processing event, id : {}", order == null ? "no id": order.getPayloadId());
		orchestrator.processPurchaseOrder(order, headers);
	}

	@Override
	@StreamListener(target = BrokerInput.SUBSCRIBE_EXCHANGE_PARTNERS_PURCHASE_ORDER_REQUESTED_WITH_WAIT)
	public void subscribeExchangePartnersPurchaseOrderRequestedWithWait(OrderDTO order,@Headers  Map<String, Object> headers) {
		logger.info("Sending event {} to wait for process",  order == null ? "no id": order.getPayloadId());
		orchestrator.processPurchaseOrder(order,headers);
	}

}
