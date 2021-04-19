package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.order;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.OrderDTO;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Map;

public interface PortInboundOrder {
    void subscribeExchangePartnersPurchaseOrderRequested(OrderDTO order, @Headers Map<String, Object> headers);
    void subscribeExchangePartnersPurchaseOrderRequestedWithWait(OrderDTO order, @Headers Map<String, Object> headers);
}
