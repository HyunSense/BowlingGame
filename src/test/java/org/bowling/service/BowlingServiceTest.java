package org.bowling.service;

import org.assertj.core.api.Assertions;
import org.bowling.constant.Bonus;
import org.bowling.dto.Frame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BowlingServiceTest {

    BowlingService bowlingService = new BowlingService();


    @AfterEach
    void clearFrameList() {

        BowlingService.frameList.clear();
    }

    @Test
    @DisplayName("1,2기회 넣었을경우 TotalScore 확인")
    void sumScore() {

        Frame frame1 = new Frame();
        frame1.setFrame(1);
        frame1.setScore(new int[]{5, 5});
        BowlingService.frameList.add(frame1);

        Assertions.assertThat(BowlingService.frameList.get(0).getTotalScore())
                .isEqualTo(10);

    }

    @Test
    @DisplayName("스페어일 경우 보너스 점수")
    void caseSpareUpdateTotalScore() {

        int frameCount = 1;
        Frame spareTestFrame1 = new Frame();
        Frame spareTestFrame2 = new Frame();

        spareTestFrame1.setFrame(1);
        spareTestFrame1.setScore(new int[]{1, 9});
        spareTestFrame1.setBonusCheck(Bonus.SPARE);

        spareTestFrame2.setFrame(2);
        spareTestFrame2.setScore(new int[]{3, 5});
        BowlingService.frameList.add(spareTestFrame1);
        BowlingService.frameList.add(spareTestFrame2);

        bowlingService.updateTotalScore(frameCount);
        Assertions.assertThat(BowlingService.frameList.get(0).getTotalScore())
                .isEqualTo(13);

    }

    @Test
    @DisplayName("스트라이크일 경우 보너스 점수")
    void caseStrikeUpdateTotalScore() {

        int frameCount = 1;

        Frame strikeTestFrame1 = new Frame();
        Frame strikeTestFrame2 = new Frame();

        strikeTestFrame1.setFrame(1);
        strikeTestFrame1.setScore(new int[]{0,10});
        strikeTestFrame1.setBonusCheck(Bonus.STRIKE);

        strikeTestFrame2.setFrame(2);
        strikeTestFrame2.setScore(new int[]{8, 1});
        BowlingService.frameList.add(strikeTestFrame1);
        BowlingService.frameList.add(strikeTestFrame2);

        bowlingService.updateTotalScore(frameCount);
        Assertions.assertThat(BowlingService.frameList.get(0).getTotalScore())
                .isEqualTo(19);

    }
}