package br.com.portobello.digital.partnerspurchaseordertracking.service.broker.vmi;

import br.com.portobello.digital.partnerspurchaseordertracking.domain.dtos.leroy.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseordertracking.service.broker.config.BrokerInput;
import br.com.portobello.digital.partnerspurchaseordertracking.service.orchestrator.TrackingVMIOrchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@EnableBinding(BrokerInput.class)
public class VMIStockInboundOrderBroker implements PortInboundVMI {

	private Logger logger = LoggerFactory.getLogger(VMIStockInboundOrderBroker.class);

	@Autowired
	private TrackingVMIOrchestrator orchestrator;

	@Override
	@StreamListener(target = BrokerInput.SUBSCRIBE_EXCHANGE_VMI_STOCK_REQUESTED)
	public void subscribeExchangeVMIStockRequested(SupplierStockRequestDTO order, @Headers Map<String, Object> headers) {
		logger.info("Processing VMI event, id : {}", order == null ? "no id": order.getPayloadId());
		orchestrator.processVMIStock(order, headers);
	}

	@Override
	@StreamListener(target = BrokerInput.SUBSCRIBE_EXCHANGE_VMI_STOCK_REQUESTED_WITH_WAIT)
	public void subscribeExchangeVMIStockRequestedWithWait(SupplierStockRequestDTO order,@Headers  Map<String, Object> headers) {
		logger.info("Sending VMI event {} to wait for process",  order == null ? "no id": order.getPayloadId());
		orchestrator.processVMIStock(order,headers);
	}

}
