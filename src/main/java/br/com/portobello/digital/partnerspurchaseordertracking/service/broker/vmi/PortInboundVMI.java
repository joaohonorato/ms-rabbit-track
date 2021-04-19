package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.vmi;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy.SupplierStockRequestDTO;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Map;

public interface PortInboundVMI {
    void subscribeExchangeVMIStockRequested(SupplierStockRequestDTO order, @Headers Map<String, Object> headers);
    void subscribeExchangeVMIStockRequestedWithWait(SupplierStockRequestDTO order, @Headers Map<String, Object> headers);
}
