package com.perhab.games.woods;

import com.perhab.games.woods.actions.DescribeAction;
import com.perhab.games.woods.actions.MoveAction;
import com.perhab.games.woods.actions.RestartAction;
import com.perhab.games.woods.request.FulfillmentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FulfillmentController {

    private final MoveAction moveAction;
    private final RestartAction restartAction;
    private final DescribeAction describeAction;

    @RequestMapping("/fulfillment")
    public FulfillmentResponse fullfillment(@RequestBody FulfillmentRequest request) {
        log.trace("Got request {}", request);
        FulfillmentResponse response = null;
        switch (request.getResult().getAction()) {
            case "game.move":
                response = moveAction.perform(request);
                break;
            case "game.start":
                response = restartAction.perform(request);
                break;
            case "game.describe":
                response = describeAction.perform(request);
                break;
        }

        if (response == null) {
            log.debug("using default response");
            response = new FulfillmentResponse();
            response.setSpeech(getSpeech(request, "Uh, Oh"));
            response.setDisplayText(getSpeech(request, "Well, this is awkward, there was an error."));
        }
        log.trace("sending response {}", response);
        return response;
    }

    private String getSpeech(@RequestBody FulfillmentRequest request, String defaultMessage) {
        if (!StringUtils.isEmpty(request.getResult().getSpeech())) {
            return request.getResult().getSpeech();
        } else if(!StringUtils.isEmpty(request.getResult().getFulfillment().getSpeech())) {
            return request.getResult().getFulfillment().getSpeech();
        } else {
            return defaultMessage;
        }
    }
}
