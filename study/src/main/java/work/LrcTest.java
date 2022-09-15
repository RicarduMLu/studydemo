package work;

import org.junit.Test;
import utils.LrcUtils;

import static constants.LrcConstants.*;

public class LrcTest {


    @Test
    public void lrc01() {
        LrcUtils.lrc(飞向别人的床, -500);
    }

    @Test
    public void lrc02() {
        LrcUtils.lrc(rightNow, 1000);
    }
    @Test
    public void lrc03() {
        LrcUtils.lrc(hurt, 1000);
    }
   @Test
    public void lrc04() {
        LrcUtils.lrc(booty_music, 500);
    }




}
