package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.order;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.OrderDTO;

import java.util.Map;

public interface PortOutboundOrder {
	void sendMessageTrackingPurchaseOrderAvailable(OrderDTO order, Map<String, Object> headers);
	void sendMessageTrackingPurchaseOrderOperationError(Object eventErrorPayload, String id, Map<String, Object> headers);
	void sendMessagePartnersPurchaseOrderSyncRequestedWait(OrderDTO order, String id, Map<String, Object> headers);
	}
