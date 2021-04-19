package br.com.portobello.digital.partnerspurchaseordertracking.domain.entities;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.OrderDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.domain.enums.TrackingStatusType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Validated
@Document(collection = "partners-purchase-order-tracking")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TrackingPurchaseOrder implements Serializable {
    @Id
    private String id;

    private TrackingStatusType status = TrackingStatusType.CREATED;

    private Instant creationDate;

    private OrderDTO purchaseOrder;

    public TrackingPurchaseOrder() {
        this.id = UUID.randomUUID().toString();
        this.creationDate = Instant.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TrackingStatusType getStatus() {
        return status;
    }

    public void setStatus(TrackingStatusType status) {
        this.status = status;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public OrderDTO getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(OrderDTO purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
