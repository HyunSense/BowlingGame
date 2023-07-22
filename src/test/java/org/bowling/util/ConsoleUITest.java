package org.bowling.util;

import org.bowling.dto.Frame;
import org.bowling.service.BowlingService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.bowling.util.ConsoleUI.*;


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
    void scoreBoard() {
        Frame frame = new Frame();
        frame.setScore(new int[]{3, 4});
        List<Frame> frameList = new ArrayList<>();
        frameList.add(frame);

        printScoreBoard(frameList);

    }
}