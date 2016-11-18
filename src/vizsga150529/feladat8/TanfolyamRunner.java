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

        //l�trehozunk egy list�t, amiben t�rolni fogjuk az adatokat
        List<Tanfolyam> tanfolyamList = new LinkedList<Tanfolyam>();

        //fileb�l olvas�s
        //a file a project mapp�j�ban van k�zvetlen�l
        try {
            BufferedReader in = new BufferedReader(new FileReader("tanfolyam.txt"));

            //ez majd a d�tum parsol�shoz kell
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");

            String sor;
            while ((sor = in.readLine()) != null){
                String[] egysegek = sor.split(",");

                //ki kell gy�jteni az adatokat,
                // hogy azzal l�trehozzunk Tanfolyam objektumokat, soronk�nt egyet
                String name = egysegek[0];
                //a d�tum olvas�s �s parse-ol�sa egy kicsit tr�kk�sebb
                Date datum = df.parse(egysegek[1]);
                String leiras = egysegek[2];
                //l�trehozzuk az objektumokat, �s a list�nkhoz adjuk
                tanfolyamList.add(new Tanfolyam(name, leiras, datum));
            }

            //fontos, hogy mindig z�rjuk be file-olvas�s v�g�n
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //�sszes tanfolyam id�rendben
        //el�sz�r rendezz�k
        tanfolyamList.sort(new Tanfolyam.timeComparator());
        //azt�n kiiratjuk
        for (Tanfolyam tanfolyam : tanfolyamList) {
            System.out.println(tanfolyam);
        }

        //mennyi janu�ri tanfolyam van?
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        int counter = 0;
        for (Tanfolyam tanfolyam : tanfolyamList) {
            if (tanfolyam.isSameMonth(cal.getTime())){
                counter++;
            };
        }
        System.out.println("Janu�ri tanfolyamok sz�ma: " + counter);

        //n�v szerint legels� tanfolyam neve
        //sorbarakjuk n�v szerint, �s ki�ratjuk az els�t
        Collections.sort(tanfolyamList);
        System.out.println(tanfolyamList.get(0).getName());

    }
}
