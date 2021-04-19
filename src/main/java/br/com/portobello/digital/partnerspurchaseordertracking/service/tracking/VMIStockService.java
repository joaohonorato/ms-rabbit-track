package br.com.portobello.digital.partnerspurchaseordertracking.service.tracking;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingVMIStock;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;

import javax.validation.constraints.NotNull;

public interface VMIStockService {
	TrackingVMIStock register(@NotNull TrackingVMIStock event);

	TrackingVMIStock updatePartnersPurchaseOrderStatus(@NotNull String trackingId, @NotNull TrackingStatusType status);

	TrackingVMIStock findById(@NotNull String trackingId);
}