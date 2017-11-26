package com.perhab.games.woods.actions;

import com.perhab.games.woods.FulfillmentResponse;
import com.perhab.games.woods.dto.Position;
import com.perhab.games.woods.request.FulfillmentRequest;
import com.perhab.games.woods.state.StateHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MoveAction extends ActionWithState {

    private final StateHolder stateHolder;

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

        FulfillmentResponse response = new FulfillmentResponse();
        response.setSpeech("You're at " + position);
        response.setDisplayText("You're at " + position);
        response.setContextOut(stateHolder.provideStateForResponse(request.getSessionId()));
        return response;
    }
}
