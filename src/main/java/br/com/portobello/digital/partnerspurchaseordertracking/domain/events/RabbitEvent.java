package br.com.portobello.digital.partnerspurchaseordertracking.domain.events;


import br.com.portobello.digital.partnerspurchaseordertracking.domain.events.commons.EventPayload;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RabbitEvent<T extends EventPayload> implements Serializable {
    @NotNull
    private T payload;

    public RabbitEvent() {
    }

    public RabbitEvent(@NotNull T event) {
        this.payload = event;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
