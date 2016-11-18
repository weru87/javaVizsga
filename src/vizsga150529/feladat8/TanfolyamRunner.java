package vizsga150529.feladat8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by weru8 on 2016. 11. 18..
 */
public class TanfolyamRunner {
    public static void main(String[] args){

        //létrehozunk egy listát, amiben tárolni fogjuk az adatokat
        List<Tanfolyam> tanfolyamList = new LinkedList<Tanfolyam>();

        //fileból olvasás
        //a file a project mappájában van közvetlenül
        try {
            BufferedReader in = new BufferedReader(new FileReader("tanfolyam.txt"));

            //ez majd a dátum parsoláshoz kell
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");

            String sor;
            while ((sor = in.readLine()) != null){
                String[] egysegek = sor.split(",");

                //ki kell gyûjteni az adatokat,
                // hogy azzal létrehozzunk Tanfolyam objektumokat, soronként egyet
                String name = egysegek[0];
                //a dátum olvasás és parse-olása egy kicsit trükkösebb
                Date datum = df.parse(egysegek[1]);
                String leiras = egysegek[2];
                //létrehozzuk az objektumokat, és a listánkhoz adjuk
                tanfolyamList.add(new Tanfolyam(name, leiras, datum));
            }

            //fontos, hogy mindig zárjuk be file-olvasás végén
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //összes tanfolyam idõrendben
        //elõször rendezzük
        tanfolyamList.sort(new Tanfolyam.timeComparator());
        //aztán kiiratjuk
        for (Tanfolyam tanfolyam : tanfolyamList) {
            System.out.println(tanfolyam);
        }

        //mennyi januári tanfolyam van?
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        int counter = 0;
        for (Tanfolyam tanfolyam : tanfolyamList) {
            if (tanfolyam.isSameMonth(cal.getTime())){
                counter++;
            };
        }
        System.out.println("Januári tanfolyamok száma: " + counter);

        //név szerint legelsõ tanfolyam neve
        //sorbarakjuk név szerint, és kiíratjuk az elsõt
        Collections.sort(tanfolyamList);
        System.out.println(tanfolyamList.get(0).getName());

    }
}
