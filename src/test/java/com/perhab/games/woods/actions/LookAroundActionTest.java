package com.perhab.games.woods.actions;

import com.perhab.games.woods.actions.LookAroundAction;
import com.perhab.games.woods.items.BigRedApple;
import com.perhab.games.woods.items.BrokenOfBranch;
import com.perhab.games.woods.items.Bush;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LookAroundActionTest {

    @Test
    public void testSingleItem() {
        assertEquals("You see a big red apple.", LookAroundAction.buildSentenceWithItems("You see", new BigRedApple()));
    }

    @Test
    public void testTwoItems() {
        assertEquals("You see a big red apple and a branch broken of a tree.", LookAroundAction.buildSentenceWithItems("You see", new BigRedApple(), new BrokenOfBranch()));
    }

    @Test
    public void testThreeItems() {
        assertEquals("You see a big red apple, a branch broken of a tree and a small bush.", LookAroundAction.buildSentenceWithItems("You see", new BigRedApple(), new BrokenOfBranch(), new Bush()));
    }
}
