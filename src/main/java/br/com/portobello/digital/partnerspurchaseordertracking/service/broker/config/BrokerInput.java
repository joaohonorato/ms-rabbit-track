package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BrokerInput {

	String SUBSCRIBE_EXCHANGE_PARTNERS_PURCHASE_ORDER_REQUESTED = "subscribeExchangePartnersPurchaseOrderRequested";
	String SUBSCRIBE_EXCHANGE_PARTNERS_PURCHASE_ORDER_REQUESTED_WITH_WAIT = "subscribeExchangePartnersPurchaseOrderRequestedWithWait";
	String SUBSCRIBE_EXCHANGE_VMI_STOCK_REQUESTED = "subscribeExchangeVMIStockRequested";
	String SUBSCRIBE_EXCHANGE_VMI_STOCK_REQUESTED_WITH_WAIT = "subscribeExchangeVMIStockRequestedWithWait";


	@Input(SUBSCRIBE_EXCHANGE_PARTNERS_PURCHASE_ORDER_REQUESTED)
    SubscribableChannel subscribeExchangePartnersPurchaseOrderRequested();

	@Input(SUBSCRIBE_EXCHANGE_PARTNERS_PURCHASE_ORDER_REQUESTED_WITH_WAIT)
    SubscribableChannel subscribeExchangePartnersPurchaseOrderRequestedWithWait();


	@Input(SUBSCRIBE_EXCHANGE_VMI_STOCK_REQUESTED)
	SubscribableChannel subscribeExchangeVMIStockRequested();

	@Input(SUBSCRIBE_EXCHANGE_VMI_STOCK_REQUESTED_WITH_WAIT)
	SubscribableChannel subscribeExchangeVMIStockRequestedWithWait();
}
