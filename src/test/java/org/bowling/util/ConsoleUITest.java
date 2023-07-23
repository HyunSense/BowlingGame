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
//            bowlingService.getScoreByFrame(i, frameObj);

        }
    }

    @Test
    void scoreBoard() {
//        Frame frame = new Frame();
//        Frame frame2 = new Frame();
//        frame.setScore(new int[]{5, 5});
//        frame2.setScore(new int[]{10, 0});
//        frame.setTotalScore(10);
//        frame2.setTotalScore(10);
//        BowlingService.frameList.add(frame);
//        BowlingService.frameList.add(frame2);
        for (int i = 1; i <= 10; i++) {

            bowlingService.getScoreByFrame(i);
        }


    }
}