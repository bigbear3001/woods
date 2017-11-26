package com.perhab.games.woods.actions;

import com.perhab.games.woods.FulfillmentResponse;
import com.perhab.games.woods.request.FulfillmentRequest;
import com.perhab.games.woods.state.StateHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestartAction implements Action {

    private final StateHolder stateHolder;

    @Override
    public FulfillmentResponse perform(FulfillmentRequest request) {
        stateHolder.resetState(request.getSessionId());

        return null;
    }
}
