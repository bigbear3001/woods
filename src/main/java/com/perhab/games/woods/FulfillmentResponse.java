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
    Object[] contextOut;
    String source;
    Object followUpEvent;
}
