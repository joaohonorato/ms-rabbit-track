package br.com.portobello.digital.partnerspurchaseordertracking.domain.events.commons;

import java.io.Serializable;

public abstract class EventPayload implements Serializable {
    protected String payloadId;

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }
}
