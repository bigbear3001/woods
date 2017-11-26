package com.perhab.games.woods.actions;

import com.perhab.games.woods.response.FulfillmentResponse;
import com.perhab.games.woods.items.Item;
import com.perhab.games.woods.map.Map;
import com.perhab.games.woods.request.FulfillmentRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LookAroundAction extends ActionWithState {

    @Override
    public FulfillmentResponse perform(FulfillmentRequest request) {
        List<Item> items = Map.getItems(getState(request).getPosition());
        String speech;
        if (items.size() != 0) {
            speech = buildSentenceWithItems("You see ", items);
        } else {
            speech = "There seems nothing interesting at this place.";
        }

        FulfillmentResponse response = new FulfillmentResponse();
        response.setSpeech(speech);
        response.setDisplayText(speech);
        return response;
    }

    public static String buildSentenceWithItems(String message, List<Item> items) {
        return buildSentenceWithItems(message, items.toArray(new Item[items.size()]));
    }

    public static String buildSentenceWithItems(String message, Item ... items) {
        StringBuilder builder = new StringBuilder(message);
        if (!message.endsWith(" ")) {
            builder.append(' ');
        }
        for (int i = 0 ; i < items.length; i++) {
            Item item = items[i];
            if (i != 0) {
                if (i + 1 == items.length) {
                    builder.append(" and ");
                } else {
                    builder.append(", ");
                }
            }
            builder.append(item.describe());
        }
        builder.append('.');
        return builder.toString();
    }
}
