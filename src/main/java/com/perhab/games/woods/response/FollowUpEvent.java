package com.perhab.games.woods.response;

import lombok.Data;

import java.util.Map;

@Data
public class FollowUpEvent {
	String name;
	Map<String, Object> data;
}
