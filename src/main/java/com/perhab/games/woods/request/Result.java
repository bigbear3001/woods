package com.perhab.games.woods.request;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
    String action;
    boolean actionIncomplete;
    Object[] contexts;
    Fulfillment fulfillment;
    Metadata metadata;
    Map<String, Object> parameters;
    String resolvedQuery;
    Float score;
    String source;
    String speech;
}
