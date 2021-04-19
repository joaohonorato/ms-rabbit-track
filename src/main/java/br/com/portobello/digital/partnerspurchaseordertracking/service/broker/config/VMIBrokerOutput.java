package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface VMIBrokerOutput {

	String PUBLISH_VMI_STOCK_AVAILABLE = "publishVMIStockAvailable";
	String PUBLISH_VMI_STOCK_REQUESTED_WITH_WAIT = "publishVMIRequestedWithWait";
	String PUBLISH_VMI_STOCK_TRACKING_OPERATION_ERROR = "publishVMIOperationError";

	String PUBLISH_VMI_STOCK_AVAILABLE_EVENT_NAME = "VMIStockAvailable";
	String PUBLISH_VMI_STOCK_SYNC_REQUESTED_WITH_WAIT_EVENT_NAME = "VMIStockRequestedWithWait";
	String PUBLISH_VMI_STOCK_TRACKING_OPERATION_ERROR_EVENT_NAME = "VMIStockOperationError";

	@Output(PUBLISH_VMI_STOCK_AVAILABLE)
    MessageChannel publishVMIStockAvailable();

	@Output(PUBLISH_VMI_STOCK_TRACKING_OPERATION_ERROR)
    MessageChannel publishVMIStockTrackingOperationError();

	@Output(PUBLISH_VMI_STOCK_REQUESTED_WITH_WAIT)
    MessageChannel publishVMIStockSyncRequestedWithWait();
}
