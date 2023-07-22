package org.bowling.util;

import org.bowling.dto.Frame;
import org.bowling.service.BowlingService;
import org.junit.jupiter.api.Test;


class ConsoleUITest {

    BowlingService bowlingService = new BowlingService();

    @Test
    void printUI() {


        for (int i = 1; i <= 10; i++) {

            Frame frameObj = new Frame();
            bowlingService.getScoreByFrame(i, frameObj);

        }
    }

    @Test
    void arrayTest() {
        int[] ints = new int[2];
        ints[0] = 1;
        ints[1] = 2;

    }
}