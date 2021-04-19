package br.com.portobello.digital.partnerspurchaseordertracking.domain.factory;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.OrderDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingPurchaseOrder;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;
import org.springframework.stereotype.Component;

@Component
public class TrackingPurchaseOrderFactory {
    public TrackingPurchaseOrder createTrackingPurchaseOrder(OrderDTO orderDTO) {
        var purchaseOrder = new TrackingPurchaseOrder();
        purchaseOrder.setId(orderDTO.getPayloadId());
        purchaseOrder.setStatus(TrackingStatusType.CREATED);
        purchaseOrder.setPurchaseOrder(orderDTO);
        return purchaseOrder;
    }
}
