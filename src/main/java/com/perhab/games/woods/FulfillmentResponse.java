package com.perhab.games.woods;

import lombok.Data;

/**
 * @link https://dialogflow.com/docs/fulfillment#response
 */
@Data
public class FulfillmentResponse {
    String speech;
    String displayText;
    Object data;
    String[] contextOut;
    String source = "game.perhab.com";
    Object followUpEvent;
}
