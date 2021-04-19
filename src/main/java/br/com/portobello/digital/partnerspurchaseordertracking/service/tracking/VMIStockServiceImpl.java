package br.com.portobello.digital.partnerspurchaseordertracking.service.tracking;

import br.com.portobello.digital.commons.exceptions.NotFoundException;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingVMIStock;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;
import br.com.portobello.digital.partnerspurchaseordertracking.repository.TrackingVMIStockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@Transactional
@Validated
public class VMIStockServiceImpl implements VMIStockService {

	private final TrackingVMIStockRepository repository;

	public VMIStockServiceImpl(TrackingVMIStockRepository repository) {
		this.repository = repository;
	}

	@Override
	public TrackingVMIStock findById(@NotNull String invoiceId) {
		Optional<TrackingVMIStock> invoice = repository.findById(invoiceId);
		
		if (invoice.isPresent())
			return invoice.get();
		
		throw new NotFoundException("Information not found");
	}

	@Override
	public TrackingVMIStock register(@NotNull TrackingVMIStock event) {

		event.setStatus(TrackingStatusType.CREATED);
				
		return repository.save(event);
	}

	@Override
	public TrackingVMIStock updatePartnersPurchaseOrderStatus(@NotNull String invoiceId, @NotNull TrackingStatusType status) {
		TrackingVMIStock invoice = findById(invoiceId);
		
		invoice.setStatus(status);
				
		return repository.save(invoice);
	}


}
