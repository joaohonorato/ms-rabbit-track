package br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy;

import java.util.List;

public class SupplierStockDTO {
    private String fiscalId;
    private List<SupplierProductsStockDTO> supplierProductsStock;
    private String returnCode;
    private String returnMessage;
    private String idConsult;

    public SupplierStockDTO() {
    }

    public SupplierStockDTO(List<SupplierProductsStockDTO> supplierProductsStock) {
        this.supplierProductsStock = supplierProductsStock;
    }

    public List<SupplierProductsStockDTO> getSupplierProductsStock() {
        return supplierProductsStock;
    }

    public void setSupplierProductsStock(List<SupplierProductsStockDTO> supplierProductsStock) {
        this.supplierProductsStock = supplierProductsStock;
    }

    public String getFiscalId() {
        return fiscalId;
    }

    public void setFiscalId(String fiscalId) {
        this.fiscalId = fiscalId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getIdConsult() {
        return idConsult;
    }

    public void setIdConsult(String idConsult) {
        this.idConsult = idConsult;
    }
}
