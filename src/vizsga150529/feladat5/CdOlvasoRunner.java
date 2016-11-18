package vizsga150529.feladat5;

import vizsga150529.feladat7.MonitorSize;

/**
 * Created by weru8 on 2016. 11. 16..
 */
public class CdOlvasoRunner {

    public static void main(String[] args) {
        CdOlvaso olvaso1 = CdOlvaso.createBySpeed("elso", 500);
        CdOlvaso olvaso2 = CdOlvaso.createByMultiplier("masodik", 3);

        MonitorSize ms = MonitorSize.KICSI;
        System.out.println(ms);
    }

}
