package com.perhab.games.woods;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FulfillmentController {
    @RequestMapping("/fullfillment")
    public FulfillmentResponse fullfillment(@RequestBody FulfillmentRequest request) {
        log.error("Got request {}", request);
        FulfillmentResponse response = null;
        log.error("sending response {}", response);
        return response;
    }
}
