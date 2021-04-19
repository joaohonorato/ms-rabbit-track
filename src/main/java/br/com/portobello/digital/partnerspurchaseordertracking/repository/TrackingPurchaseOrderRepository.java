package br.com.portobello.digital.partnerspurchaseordertracking.repository;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.entities.TrackingPurchaseOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackingPurchaseOrderRepository extends MongoRepository<TrackingPurchaseOrder, String> {
}
