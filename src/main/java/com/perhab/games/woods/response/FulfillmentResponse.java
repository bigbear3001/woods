package com.perhab.games.woods.response;

import com.perhab.games.woods.response.FollowUpEvent;
import lombok.Data;

/**
 * @link https://dialogflow.com/docs/fulfillment#response
 */
@Data
public class FulfillmentResponse {
    String speech;
    String displayText;
    Object data;
    Object[] contextOut;
    String source = "game.perhab.com";
    FollowUpEvent followUpEvent;
}
