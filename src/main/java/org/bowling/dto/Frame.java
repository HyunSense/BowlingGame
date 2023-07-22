package org.bowling.dto;

import org.bowling.constant.Bonus;

import java.util.Arrays;
import java.util.Objects;

public class Frame {

    int frame;
    int[] score;
    int totalScore;
    Bonus bonusCheck;


    public int getFrame() {
        return frame;
    }

    public int[] getScore() {
        return score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public Bonus getBonusCheck() {
        return bonusCheck;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setBonusCheck(Bonus bonusCheck) {
        this.bonusCheck = bonusCheck;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "frame=" + frame +
                ", score=" + Arrays.toString(score) +
                ", totalScore=" + totalScore +
                '}';
    }
}
