package com.perhab.games.woods;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class RequestLoggingFilter extends CommonsRequestLoggingFilter {

    {
        setIncludeClientInfo(true);
        setIncludeQueryString(true);
        setIncludePayload(true);
        setMaxPayloadLength(8*1024);
    }

    protected String createMessage(HttpServletRequest request, String prefix, String suffix) {
        try {
            //we make sure content is read at least once before using it
            IOUtils.toString(request.getInputStream());
        } catch (IOException e) {
            log.error("error reading content");
        }
        return super.createMessage(request, prefix, suffix);
    }

}
