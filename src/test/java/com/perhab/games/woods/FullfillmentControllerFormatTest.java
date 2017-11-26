package com.perhab.games.woods;

import org.junit.Test;
import org.mockito.Mock;

public class FullfillmentControllerFormatTest {

    @Mock
    FulfillmentController controller;

    @Test
    public void testController() {
        controller.fullfillment(null);
    }
}
