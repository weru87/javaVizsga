package vizsga150529.feladat5;

/**
 * Created by weru8 on 2016. 11. 16..
 */
public class CdOlvaso {
    private String nev;
    private int sebesseg;

    /*
    Lehessen létrehozni a név és a sebesség megadásával (pl. „Asus”, 300)
    valamint lehessen létrehozni név és sebességszorzó (pl. „Asus”, 2 szeres) megadásával is
    !!nem lehet ugyanaz a szigantúra a konstruktoroknál
    ezért ezt gyártófüggvényekkel oldjuk meg!!
     */

    //a konstruktor private, összevont paraméterezéssel
    private CdOlvaso(String nev, int sebesseg, int szorzo){
        this.nev = nev;
        if (szorzo == 0){
            this.sebesseg = sebesseg;
        } else {
            this.sebesseg = szorzo * sebesseg;
        }
    }

    //majd készítsünk az osztályhoz beszédes nevû publikus statikus metódusokat,
    // amelyek elõállítanak és visszaadnak egy példányt.
    public static  CdOlvaso createBySpeed(String nev, int sebesseg){
        return new CdOlvaso(nev, sebesseg, 0);
    }

    public static CdOlvaso createByMultiplier(String nev, int szorzo) {
        return new CdOlvaso(nev, 150, szorzo);
    }


}
