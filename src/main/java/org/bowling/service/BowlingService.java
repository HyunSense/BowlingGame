package org.bowling.service;

import org.bowling.constant.Bonus;
import org.bowling.dto.Frame;

import java.util.ArrayList;
import java.util.List;

import static org.bowling.util.ConsoleUI.*;

public class BowlingService {

    private static final int COUNT = 2;
    public static List<Frame> frameList = new ArrayList<>();



     public void getScoreByFrame(int frame) {

         printStartFrame(frame);

         Frame frameObj = new Frame();
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
                 frameObj.setBonusCheck(Bonus.STRIKE);
                 break;
             }

             if (score != 0 && totalScore == 10) {
                 frameObj.setBonusCheck(Bonus.SPARE);

             }

             printBonusUi(frameObj);
         }

         frameObj.setScore(scores);
         frameObj.setTotalScore(totalScore);
         frameList.add(frameObj);

         printEndFrame(frame);

     }

     public void updateTotalScore(int frameCount) {

         if (frameList.size() > 1) {
             Frame prevFrame = frameList.get(frameCount - 1);
             Frame frame = frameList.get(frameCount);

             if (prevFrame.getBonusCheck() == Bonus.SPARE) {
                 prevFrame.setTotalScore(prevFrame.getTotalScore() + frame.getScore()[0]);

             } else if (prevFrame.getBonusCheck() == Bonus.STRIKE) {
                 prevFrame.setTotalScore(prevFrame.getTotalScore() + frame.getTotalScore());
             }
         }
     }
}
