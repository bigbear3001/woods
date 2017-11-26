package com.perhab.games.woods.map;

import com.perhab.games.woods.dto.Position;
import com.perhab.games.woods.items.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapTest {

    @Test
    public void testGettingNothingAtStart() {
        Position position = new Position();
        List<Item> items = Map.getItems(position);
        assertEquals("Expected 0 items for default position", 0, items.size());
    }

    @Test
    public void testGetSomethingWithin5Paces() {
        List<Item> items = new ArrayList<>();
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                items.addAll(Map.getItems(new Position(x, y)));
            }
        }
        int minItems = 1;
        int maxItems = 60;
        assertTrue("Expected to get no more than " + maxItems + " items (got " + items.size() + ")", items.size() <= maxItems);
        assertTrue("Expected to get no less than " + minItems + " items (got " + items.size() + ")", items.size() >= minItems);
    }
}
