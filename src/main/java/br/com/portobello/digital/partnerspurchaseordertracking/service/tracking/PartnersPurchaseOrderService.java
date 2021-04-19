package br.com.portobello.digital.partnerspurchaseordertracking.service.tracking;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingPurchaseOrder;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;

import javax.validation.constraints.NotNull;

public interface PartnersPurchaseOrderService {
	TrackingPurchaseOrder register(@NotNull TrackingPurchaseOrder event);

	TrackingPurchaseOrder updatePartnersPurchaseOrderStatus(@NotNull String trackingId, @NotNull TrackingStatusType status);

	TrackingPurchaseOrder findById(@NotNull String trackingId);
}