package com.perhab.games.woods.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
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
