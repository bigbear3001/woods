package com.perhab.games.woods;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class RequestLoggingFilter extends AbstractRequestLoggingFilter {

    {
        setIncludeClientInfo(true);
        setIncludeQueryString(true);
        setIncludePayload(true);
    }

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String message) {
        log.info(message);
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String message) {
        log.info(message);
    }
}
