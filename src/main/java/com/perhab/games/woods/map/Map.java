package com.perhab.games.woods.map;

import com.perhab.games.woods.dto.Position;
import com.perhab.games.woods.items.BigRedApple;
import com.perhab.games.woods.items.BrokenOfBranch;
import com.perhab.games.woods.items.Bush;
import com.perhab.games.woods.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    public static List<Item> getItems(Position position) {
        long seed = position.getX() * 37 + position.getY() * 41;
        ArrayList<Item> items = new ArrayList<>();
        add(items, new Bush(), 0.7, seed);
        add(items, new BrokenOfBranch(), 0.2, seed);
        add(items, new BigRedApple(), 0.01, seed);
        return items;
    }

    private static void add(ArrayList<Item> items, Item item, double chance, long seed) {
        Random random = new Random(seed);
        if (random.nextDouble() <= chance) {
            items.add(item);
        }
    }
}
