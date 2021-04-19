package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.vmi;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy.SupplierStockRequestDTO;

import java.util.Map;

public interface PortOutboundVMI {
	void sendMessageVMIStockAvailable(SupplierStockRequestDTO order, Map<String, Object> headers);
	void sendMessageTrackingVMIStockOperationError(Object eventErrorPayload, String id, Map<String, Object> headers);
	void sendMessageVMIStockSyncRequestedWait(SupplierStockRequestDTO order, String id, Map<String, Object> headers);
}
