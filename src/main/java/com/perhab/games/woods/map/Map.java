package com.perhab.games.woods.map;

import com.perhab.games.woods.dto.Position;
import com.perhab.games.woods.items.BrokenOfBranch;
import com.perhab.games.woods.items.Bush;
import com.perhab.games.woods.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static List<Item> getItems(Position position) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Bush());
        items.add(new BrokenOfBranch());
        return items;
    }
}
