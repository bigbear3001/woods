package com.perhab.games.woods.actions;

import com.perhab.games.woods.dto.State;
import com.perhab.games.woods.request.FulfillmentRequest;
import com.perhab.games.woods.state.StateHolder;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ActionWithState implements Action {

    @Autowired
    StateHolder holder;

    protected State getState(FulfillmentRequest request) {
        return getState(request.getSessionId());
    }

    protected State getState(String sessionId) {
        return holder.getState(sessionId);
    }
}
