package br.com.portobello.digital.partnerspurchaseordertracking.service.tracking;

import br.com.portobello.digital.commons.exceptions.NotFoundException;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingPurchaseOrder;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;
import br.com.portobello.digital.partnerspurchaseordertracking.repository.TrackingPurchaseOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@Transactional
@Validated
public class PartnersPurchaseOrderServiceImpl implements PartnersPurchaseOrderService {

	private final TrackingPurchaseOrderRepository repository;

	public PartnersPurchaseOrderServiceImpl(TrackingPurchaseOrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public TrackingPurchaseOrder findById(@NotNull String invoiceId) {
		Optional<TrackingPurchaseOrder> invoice = repository.findById(invoiceId);
		
		if (invoice.isPresent())
			return invoice.get();
		
		throw new NotFoundException("Information not found");
	}

	@Override
	public TrackingPurchaseOrder register(@NotNull TrackingPurchaseOrder event) {

		event.setStatus(TrackingStatusType.CREATED);
				
		return repository.save(event);
	}

	@Override
	public TrackingPurchaseOrder updatePartnersPurchaseOrderStatus(@NotNull String invoiceId, @NotNull TrackingStatusType status) {
		TrackingPurchaseOrder invoice = findById(invoiceId);
		
		invoice.setStatus(status);
				
		return repository.save(invoice);
	}


}
