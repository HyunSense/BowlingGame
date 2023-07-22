package org.bowling.service;

import org.bowling.constant.Bonus;
import org.bowling.dto.Frame;

import java.util.ArrayList;
import java.util.List;

public class BowlingService {

    private static final int COUNT = 2;
    public static List<Frame> frameList = new ArrayList<>();
    int[] scores;



     public List<Frame> play(int frame) {

         Frame frameObj = new Frame();

         int pin = 10;
         int score = 0;

         for (int i = 0; i < COUNT; i++) {
             scores = new int[COUNT];

             score = (int) (Math.random() * (11 - score));
             scores[i] = score;
             pin -= score;

             if (score == 10) {
                 System.out.println("=== STRIKE ===");
                 frameObj.setBonusCheck(Bonus.STRIKE);
                 break;
             }

             if (pin != 10 && (pin - scores[COUNT -1]) == 0) {
                 frameObj.setBonusCheck(Bonus.SPARE);
                 System.out.println("=== SPARE ===");
             }
         }

         frameObj.setScore(scores);
         frameList.add(frameObj);
         
         return frameList;
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
