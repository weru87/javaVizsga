package vizsga150529.feladat5;

/**
 * Created by weru8 on 2016. 11. 16..
 */
public class CdOlvaso {
    private String nev;
    private int sebesseg;

    /*
    Lehessen l�trehozni a n�v �s a sebess�g megad�s�val (pl. �Asus�, 300)
    valamint lehessen l�trehozni n�v �s sebess�gszorz� (pl. �Asus�, 2 szeres) megad�s�val is
    !!nem lehet ugyanaz a szigant�ra a konstruktorokn�l
    ez�rt ezt gy�rt�f�ggv�nyekkel oldjuk meg!!
     */

    //a konstruktor private, �sszevont param�terez�ssel
    private CdOlvaso(String nev, int sebesseg, int szorzo){
        this.nev = nev;
        if (szorzo == 0){
            this.sebesseg = sebesseg;
        } else {
            this.sebesseg = szorzo * sebesseg;
        }
    }

    //majd k�sz�ts�nk az oszt�lyhoz besz�des nev� publikus statikus met�dusokat,
    // amelyek el��ll�tanak �s visszaadnak egy p�ld�nyt.
    public static  CdOlvaso createBySpeed(String nev, int sebesseg){
        return new CdOlvaso(nev, sebesseg, 0);
    }

    public static CdOlvaso createByMultiplier(String nev, int szorzo) {
        return new CdOlvaso(nev, 150, szorzo);
    }


}
