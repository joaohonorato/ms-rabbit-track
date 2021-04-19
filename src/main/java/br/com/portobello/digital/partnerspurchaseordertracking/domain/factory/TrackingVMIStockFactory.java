package br.com.portobello.digital.partnerspurchaseordertracking.domain.factory;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingVMIStock;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;
import org.springframework.stereotype.Component;

@Component
public class TrackingVMIStockFactory {
    public TrackingVMIStock createTrackingVMIStock(SupplierStockRequestDTO event) {
        TrackingVMIStock vmiStock = new TrackingVMIStock();
        vmiStock.setId(event.getPayloadId());
        vmiStock.setStatus(TrackingStatusType.CREATED);
        vmiStock.setStockRequestDTO(event);
        return vmiStock;
    }
}
