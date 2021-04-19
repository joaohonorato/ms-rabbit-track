package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.order;

import br.com.portobello.digital.commons.broker.GenericBrokerOutput;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.OrderDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.service.broker.config.OrderBrokerOutput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
@EnableBinding({ OrderBrokerOutput.class })
public class PurchaseOrderOutboundOrderBroker extends GenericBrokerOutput implements PortOutboundOrder {

	private final OrderBrokerOutput output;

	public PurchaseOrderOutboundOrderBroker(OrderBrokerOutput output) {
		this.output = output;
	}

	@Override
	protected Object getPortOutbound() {
		return output;
	}

	@Override
	public void sendMessageTrackingPurchaseOrderAvailable(OrderDTO order, Map<String, Object> headers) {
		buildSendBusinessMessage(output.publishPartnersPurchaseOrderAvailable(), order, order.getPayloadId(),
				OrderBrokerOutput.PUBLISH_PARTNERS_PURCHASE_ORDER_AVAILABLE_EVENT_NAME, headers);
	}

	@Override
	public void sendMessageTrackingPurchaseOrderOperationError(Object eventErrorPayload, String id, Map<String, Object> headers) {
		buildSendBusinessMessage(output.publishPartnersPurchaseOrderTrackingOperationError(), eventErrorPayload, id,
				OrderBrokerOutput.PUBLISH_PARTNERS_PURCHASE_ORDER_SYNC_REQUESTED_WITH_WAIT_EVENT_NAME, headers);
	}

	@Override
	public void sendMessagePartnersPurchaseOrderSyncRequestedWait(OrderDTO order, String id, Map<String, Object> headers) {
		buildSendBusinessMessage(output.publishPartnersPurchaseOrderSyncRequestedWithWait(), order, order.getPayloadId(),
				OrderBrokerOutput.PUBLISH_PARTNERS_PURCHASE_TRACKING_OPERATION_ERROR_EVENT_NAME,headers);
	}

}