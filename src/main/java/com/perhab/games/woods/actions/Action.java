package com.perhab.games.woods.actions;

import com.perhab.games.woods.response.FulfillmentResponse;
import com.perhab.games.woods.request.FulfillmentRequest;

public interface Action {
    FulfillmentResponse perform(FulfillmentRequest request);
}
