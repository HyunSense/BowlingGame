package org.bowling.util;

import org.bowling.constant.Bonus;
import org.bowling.dto.Frame;

public class ConsoleUI {

    public static void printStartFrame(int frame) {
        System.out.println("\n=========== FRAME [" + frame + "] START ===========\n");
    }

    public static void printEndFrame(int frame) {
        System.out.println("\n=========== FRAME [" + frame + "] END ===========\n");
    }

    public static void printBonusUi(Frame frameObj) {

        if (frameObj.getBonusCheck() == Bonus.SPARE)
            System.out.println("   === SPARE !!! ===");

        if (frameObj.getBonusCheck() == Bonus.STRIKE)
            System.out.println("   === STRIKE !!! ===");
    }

    public static void printNowScore(int score, int pin) {

        System.out.println("   === [" + score + "] 개가 쓰려졌습니다 !!! ===");
        System.out.println("   === 핀이 [" + pin + "] 개 남았습니다. !!! ===\n");

    }
}
