package org.bowling.util;

import org.bowling.dto.Frame;
import org.bowling.service.BowlingService;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConsoleUITest {

    BowlingService bowlingService = new BowlingService();

    @Test
    void printUI() {

        for (int i = 0; i <= 10; i++) {

           bowlingService.getScoreByFrame(i + 1);

        }
    }

    @Test
    void arrayTest() {
        int[] ints = new int[2];
        ints[0] = 1;
        ints[1] = 2;

    }
}