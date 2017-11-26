package com.perhab.games.woods.state;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perhab.games.woods.dto.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class StateHolder {
    HashMap<String, State> states = new HashMap<>();

    public State getState(String sessionId) {
        if (!states.containsKey(sessionId)) {
            resetState(sessionId);
        }
        return states.get(sessionId);
    }

    public void resetState(String sessionId) {
        states.put(sessionId, new State());
    }

}
