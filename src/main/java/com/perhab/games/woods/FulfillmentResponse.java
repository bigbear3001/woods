package com.perhab.games.woods;

import lombok.Data;

import java.util.Map;

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
    Object followUpEvent;
}
