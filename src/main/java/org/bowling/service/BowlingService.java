package org.bowling.service;

import org.bowling.constant.Bonus;
import org.bowling.dto.Frame;

import java.util.ArrayList;
import java.util.List;

import static org.bowling.util.ConsoleUI.*;

public class BowlingService {

    private static final int COUNT = 2;
    public static List<Frame> frameList = new ArrayList<>();

     public void getScoreByFrame(int frameCount) {

         Frame frame = new Frame();

         printStartFrame(frameCount);

         int[] scores = new int[COUNT];

         int pin = 10;
         int score = 0;
         int totalScore = 0;

         for (int i = 0; i < COUNT; i++) {

             score = (int) (Math.random() * (11 - score));
             scores[i] = score;
             totalScore += score;
             pin -= score;
             printNowScore(score, pin);


             if (score == 10) {
                 frame.setBonusCheck(Bonus.STRIKE);
                 break;
             }

             if (score != 0 && totalScore == 10) {
                 frame.setBonusCheck(Bonus.SPARE);
             }
         }

         printBonusUi(frame);
         printEndFrame(frameCount);

         frame.setScore(scores);
         frame.setTotalScore(totalScore);
         frameList.add(frame);

         updateTotalScore(frameCount);
         printScoreBoard(frameList);

     }

     public int updateTotalScore(int frameCount) {

         int sumTotalScore = 0;

         if (frameList.size() > 1) {
             Frame prevFrame = frameList.get(frameCount - 1);
             Frame frame = frameList.get(frameCount);

             if (prevFrame.getBonusCheck() == Bonus.SPARE) {
                 prevFrame.setTotalScore(prevFrame.getTotalScore() + frame.getScore()[0]);

             } else if (prevFrame.getBonusCheck() == Bonus.STRIKE) {
                 prevFrame.setTotalScore(prevFrame.getTotalScore() + frame.getTotalScore());
             }
         }

         for (Frame frame : frameList) {
             int totalScore = frame.getTotalScore();
             sumTotalScore += totalScore;
         }

         return sumTotalScore;
     }
}
