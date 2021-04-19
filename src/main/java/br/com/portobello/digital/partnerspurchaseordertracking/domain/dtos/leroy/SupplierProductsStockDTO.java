package br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy;

import java.math.BigDecimal;

public class SupplierProductsStockDTO {

     private BigDecimal availableStock;
     private BigDecimal minimumSalesQuantity;
     private String operation;
     private String productEAN;
     private String productId;
     private String purchaseDistributionProfile;
     private String stockDate;
     private String supplierProductId;
     private String supplierSalesUnitMeasure;
     private String supplierTransactionId;

    public BigDecimal getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(BigDecimal availableStock) {
        this.availableStock = availableStock;
    }

    public BigDecimal getMinimumSalesQuantity() {
        return minimumSalesQuantity;
    }

    public void setMinimumSalesQuantity(BigDecimal minimumSalesQuantity) {
        this.minimumSalesQuantity = minimumSalesQuantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getProductEAN() {
        return productEAN;
    }

    public void setProductEAN(String productEAN) {
        this.productEAN = productEAN;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPurchaseDistributionProfile() {
        return purchaseDistributionProfile;
    }

    public void setPurchaseDistributionProfile(String purchaseDistributionProfile) {
        this.purchaseDistributionProfile = purchaseDistributionProfile;
    }

    public String getStockDate() {
        return stockDate;
    }

    public void setStockDate(String stockDate) {
        this.stockDate = stockDate;
    }

    public String getSupplierProductId() {
        return supplierProductId;
    }

    public void setSupplierProductId(String supplierProductId) {
        this.supplierProductId = supplierProductId;
    }

    public String getSupplierSalesUnitMeasure() {
        return supplierSalesUnitMeasure;
    }

    public void setSupplierSalesUnitMeasure(String supplierSalesUnitMeasure) {
        this.supplierSalesUnitMeasure = supplierSalesUnitMeasure;
    }

    public String getSupplierTransactionId() {
        return supplierTransactionId;
    }

    public void setSupplierTransactionId(String supplierTransactionId) {
        this.supplierTransactionId = supplierTransactionId;
    }
}
