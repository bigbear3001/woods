package com.perhab.games.woods;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class RequestLoggingControllerAdvisor {

    @ModelAttribute
    public void addAttributes(@RequestBody String requestString) {
        // do whatever you want to do on the request body and header.
        // with request object you can get the request method and request path etc.
        log.trace("requestString {}", requestString);
    }

}
