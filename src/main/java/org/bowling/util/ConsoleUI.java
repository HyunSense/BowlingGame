package org.bowling.util;

import org.bowling.constant.Bonus;
import org.bowling.dto.Frame;

import java.util.List;

public class ConsoleUI {

    private static final int MAX_FRAME = 10;

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

    public static void printScoreBoard(List<Frame> frameList) {

        for (int i = 1; i < MAX_FRAME+1; i++) {
            System.out.print("    ["+ i +"]   ");
        }

        System.out.println();

        for (int i = 0; i < MAX_FRAME; i++) {

            if (i == 0)
                System.out.print("┏━━━━┳━━━━┳");
            else if (i == MAX_FRAME - 1) {
                System.out.print("━━━━┳━━━━┓");
            } else {
                System.out.print("━━━━┳━━━━┳");
            }

        }

        System.out.println();

        for (int i = 0; i < MAX_FRAME; i++) {

            if (i == 0) {
                System.out.printf("┃ %-2s ┃" +  " %-2s ┃", frameList.get(0).getScore()[0],frameList.get(0).getScore()[1]);

            } else {
                System.out.printf(" %-2s ┃ %-2s ┃",  frameList.get(0).getScore()[0], frameList.get(0).getScore()[1]);
            }
        }

        System.out.println();

        for (int i = 0; i < MAX_FRAME; i++) {
            if (i == 0) {
                System.out.print("┣━━━━┻━━━━╋");
            } else {
                System.out.print("━━━━┻━━━━┫");
            }
        }

        System.out.println();

        for (int i = 0; i < MAX_FRAME; i++) {
            if (i == 0) {
                System.out.printf("┃   %-3s   ┃", frameList.get(0).getTotalScore());
            } else {
                System.out.printf("   %-3s   ┃", + frameList.get(0).getTotalScore());
            }
        }

        System.out.println();

        for (int i = 0; i < MAX_FRAME; i++) {
            if (i == 0) {
                System.out.print("┗━━━━━━━━━┛");
            } else {
                System.out.print("━━━━━━━━━┛");

            }
        }

    }
}
