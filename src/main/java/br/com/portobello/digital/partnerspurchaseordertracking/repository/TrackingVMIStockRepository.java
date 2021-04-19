package br.com.portobello.digital.partnerspurchaseordertracking.repository;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingVMIStock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackingVMIStockRepository extends MongoRepository<TrackingVMIStock, String> {
}
