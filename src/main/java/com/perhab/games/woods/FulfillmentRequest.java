package com.perhab.games.woods;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
public class FulfillmentRequest {
    private UUID id;
    private String lang;
    private Result result;
    String sessionId;
    Status status;
    Date timestamp;
    OriginalRequest originalRequest;

    @Data
    private static class Result {
        String action;
        boolean actionIncomplete;
        String[] contexts;
        Fulfillment fulfillment;
        Metadata metadata;
        Map<String, Object> parameters;
        String resolvedQuery;
        Float score;
        String source;
        String speech;
    }

    @Data
    private static class Fulfillment {
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

    @Data
    private static class OriginalRequest {
        String source;
        OriginalData data;
    }

    @Data
    private static class OriginalData {
        Input[] inputs;
        User user;
        Conversation conversation;
    }

    @Data
    private static class Input {
        @JsonProperty("raw_inputs")
        RawInput[] rawInputs;
        String intent;
        Argument[] arguments;
    }

    @Data
    private static class User {
        @JsonProperty("user_id")
        String userId;
    }

    @Data
    private static class Conversation {
        @JsonProperty("conversation_id")
        String conversationId;
        String type;
        @JsonProperty("conversation_token")
        String conversationToken;
    }

    @Data
    private static class RawInput {
        String query;
        @JsonProperty("input_type")
        Integer inputType;
    }

    @Data
    private static class Argument {
        @JsonProperty("text_value")
        String textValue;
        @JsonProperty("raw_text")
        String rawText;
        String name;
    }
}
