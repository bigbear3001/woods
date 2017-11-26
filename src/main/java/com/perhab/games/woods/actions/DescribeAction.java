package com.perhab.games.woods.actions;

import com.perhab.games.woods.FulfillmentResponse;
import com.perhab.games.woods.items.Item;
import com.perhab.games.woods.map.Map;
import com.perhab.games.woods.request.FulfillmentRequest;
import org.springframework.stereotype.Component;

@Component
public class DescribeAction extends ActionWithState {

    @Override
    public FulfillmentResponse perform(FulfillmentRequest request) {
        StringBuilder builder = new StringBuilder("You see ");
        for (Item item : Map.getItems(getState(request).getPosition())) {
            builder.append(item.describe());
        }
        FulfillmentResponse response = new FulfillmentResponse();
        response.setSpeech(builder.toString());
        response.setDisplayText(builder.toString());
        return response;
    }
}
