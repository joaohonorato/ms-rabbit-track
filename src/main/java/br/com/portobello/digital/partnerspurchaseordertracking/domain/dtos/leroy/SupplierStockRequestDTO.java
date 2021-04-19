package br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy;


import br.com.portobello.digital.partnerspurchaseordertracking.domain.events.commons.EventPayload;

public class SupplierStockRequestDTO extends EventPayload {

    private SupplierStockDTO supplierStock;

    public SupplierStockRequestDTO() {
    }

    public SupplierStockRequestDTO(SupplierStockDTO supplierStock) {
        this.supplierStock = supplierStock;
    }

    public SupplierStockDTO getSupplierStock() {
        return supplierStock;
    }

    public void setSupplierStock(SupplierStockDTO supplierStock) {
        this.supplierStock = supplierStock;
    }
}
