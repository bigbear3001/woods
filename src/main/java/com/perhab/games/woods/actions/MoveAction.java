package com.perhab.games.woods.actions;

import com.perhab.games.woods.FulfillmentResponse;
import com.perhab.games.woods.dto.Position;
import com.perhab.games.woods.request.FulfillmentRequest;
import com.perhab.games.woods.state.StateHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class MoveAction extends ActionWithState {

    private final StateHolder stateHolder;

    private final LookAroundAction lookAroundAction;

    @Override
    public FulfillmentResponse perform(FulfillmentRequest request) {
        Position position = getState(request).getPosition();
        String direction = (String) request.getResult().getParameters().get("direction");
        switch (direction) {
            case "north":
                position.setY(position.getY() - 1);
                break;
            case "south":
                position.setY(position.getY() + 1);
                break;
            case "west":
                position.setX(position.getX() - 1);
                break;
            case "east":
                position.setX(position.getX() + 1);
                break;
            default:
                log.error("unknown direction {}", direction);
                break;
        }

        if (userHasFlag(request, "autolookaround")) {
            return lookAroundAction.perform(request);
        } else {
            FulfillmentResponse response = new FulfillmentResponse();
            String speech = "You walked a bit " + direction;
            if (userHasFlag(request, "debug")) {
                speech += ". You are currently at " + position;
            }
            response.setSpeech(speech);
            response.setDisplayText(speech);
            //response.setContextOut(new Object[]{stateHolder.getState(request.getSessionId())});
            return response;
        }
    }

    private boolean userHasFlag(FulfillmentRequest request, String flag) {
        return Arrays.stream(request.getResult().getContexts())
                .filter(Objects::nonNull)
                .map((object) -> ((Map<String, Object>) object).get("parameters"))
                .filter(Objects::nonNull)
                .anyMatch((parameters) -> ((Map<String, Object>) parameters).containsKey(flag));
    }
}
