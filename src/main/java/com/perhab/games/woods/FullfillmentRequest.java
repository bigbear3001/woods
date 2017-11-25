package com.perhab.games.woods;

import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
public class FullfillmentRequest {
    private UUID id;
    private String lang;
    private Result result;
    String sessionid;
    Status status;
    Date timestamp;

    @Data
    private static class Result {
        String action;
        boolean actionIncomplete;
        String[] contexts;
        Fullfillment fullfillment;
        Metadata metadata;
        Map<String, Object> parameters;
        String resolvedQuery;
        Integer score;
        String source;

    }

    @Data
    private static class Fullfillment {
        Message[] messages;
        String speech;

    }

    @Data
    private static class Message {
        String plattform;
        String textToSpeech;
        String type;
        String speech;
    }

    @Data
    private static class Metadata {
        UUID intentId;
        String intentName;
        String webhookForSlotFillingUsed;
        String webhookUsed;
    }

    @Data
    private static class Status {
        Integer code;
        String errorType;
    }
}
