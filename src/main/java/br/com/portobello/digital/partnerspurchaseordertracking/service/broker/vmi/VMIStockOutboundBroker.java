package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.vmi;

import br.com.portobello.digital.commons.broker.GenericBrokerOutput;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.service.broker.config.VMIBrokerOutput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
@EnableBinding({ VMIBrokerOutput.class })
public class VMIStockOutboundBroker extends GenericBrokerOutput implements PortOutboundVMI {

	private final VMIBrokerOutput output;

	public VMIStockOutboundBroker(VMIBrokerOutput output) {
		this.output = output;
	}

	@Override
	protected Object getPortOutbound() {
		return output;
	}

	@Override
	public void sendMessageVMIStockAvailable(SupplierStockRequestDTO order, Map<String, Object> headers) {
		buildSendBusinessMessage(output.publishVMIStockAvailable(), order, order.getPayloadId(),
				VMIBrokerOutput.PUBLISH_VMI_STOCK_AVAILABLE_EVENT_NAME, headers);
	}

	@Override
	public void sendMessageTrackingVMIStockOperationError(Object eventErrorPayload, String id, Map<String, Object> headers) {
		buildSendBusinessMessage(output.publishVMIStockTrackingOperationError(), eventErrorPayload, id,
				VMIBrokerOutput.PUBLISH_VMI_STOCK_TRACKING_OPERATION_ERROR_EVENT_NAME, headers);
	}

	@Override
	public void sendMessageVMIStockSyncRequestedWait(SupplierStockRequestDTO order, String id, Map<String, Object> headers) {
		buildSendBusinessMessage(output.publishVMIStockSyncRequestedWithWait(), order, order.getPayloadId(),
				VMIBrokerOutput.PUBLISH_VMI_STOCK_SYNC_REQUESTED_WITH_WAIT_EVENT_NAME,headers);
	}

}