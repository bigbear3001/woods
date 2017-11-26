package com.perhab.games.woods.actions;

import com.perhab.games.woods.FulfillmentResponse;
import com.perhab.games.woods.dto.Position;
import com.perhab.games.woods.request.FulfillmentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Slf4j
public class MoveAction implements Action {

    HashMap<String, Position> positions = new HashMap<>();

    @Override
    public FulfillmentResponse perform(FulfillmentRequest request) {
        if (!positions.containsKey(request.getSessionId())) {
            positions.put(request.getSessionId(), new Position());
        }
        Position position = positions.get(request.getSessionId());
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
        return response;
    }
}
