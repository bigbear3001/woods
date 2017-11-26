package com.perhab.games.woods;

import com.perhab.games.woods.actions.MoveAction;
import com.perhab.games.woods.request.FulfillmentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FulfillmentController {

    private final MoveAction moveAction;

    @RequestMapping("/fulfillment")
    public FulfillmentResponse fullfillment(@RequestBody FulfillmentRequest request) {
        log.trace("Got request {}", request);
        FulfillmentResponse response = null;
        switch (request.getResult().getAction()) {
            case "game.move":
                response = moveAction.perform(request);
                break;
        }

        if (response == null) {
            response = new FulfillmentResponse();
            response.setSpeech("Uh Oh");
            response.setDisplayText("Well, this is awkward ;-)");
        }
        log.trace("sending response {}", response);
        return response;
    }
}
