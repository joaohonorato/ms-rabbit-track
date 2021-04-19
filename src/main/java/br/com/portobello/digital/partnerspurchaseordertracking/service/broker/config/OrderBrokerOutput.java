package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface OrderBrokerOutput {

	String PUBLISH_PARTNERS_PURCHASE_ORDER_AVAILABLE = "publishPartnersPurchaseOrderAvailable";
	String PUBLISH_PARTNERS_PURCHASE_ORDER_REQUESTED_WITH_WAIT = "publishDataRequestedWithWait";
	String PUBLISH_PARTNERS_PURCHASE_TRACKING_OPERATION_ERROR = "publishOperationError";

	String PUBLISH_PARTNERS_PURCHASE_ORDER_AVAILABLE_EVENT_NAME = "PartnersPurchaseOrderAvailable";
	String PUBLISH_PARTNERS_PURCHASE_ORDER_SYNC_REQUESTED_WITH_WAIT_EVENT_NAME = "PartnersPurchaseOrderRequestedWithWait";
	String PUBLISH_PARTNERS_PURCHASE_TRACKING_OPERATION_ERROR_EVENT_NAME = "PartnersPurchaseOrderOperationError";

	@Output(PUBLISH_PARTNERS_PURCHASE_ORDER_AVAILABLE)
    MessageChannel publishPartnersPurchaseOrderAvailable();

	@Output(PUBLISH_PARTNERS_PURCHASE_TRACKING_OPERATION_ERROR)
    MessageChannel publishPartnersPurchaseOrderTrackingOperationError();

	@Output(PUBLISH_PARTNERS_PURCHASE_ORDER_REQUESTED_WITH_WAIT)
    MessageChannel publishPartnersPurchaseOrderSyncRequestedWithWait();
}
