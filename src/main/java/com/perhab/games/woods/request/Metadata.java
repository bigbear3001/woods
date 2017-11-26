package com.perhab.games.woods.request;

import lombok.Data;

import java.util.UUID;

@Data
public class Metadata {
    UUID intentId;
    String intentName;
    String webhookForSlotFillingUsed;
    String webhookUsed;
}
