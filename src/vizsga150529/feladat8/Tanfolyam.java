package vizsga150529.feladat8;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by weru8 on 2016. 11. 18..
 */
public class Tanfolyam implements Comparable<Tanfolyam> {
    //a.	Tudja tárolni egy tanfolyam nevét (szöveg), leírását (szöveg), idõpontját (dátum és idõ) (Date).
    private String name;
    private String description;
    private Date appointment;

    //b.	Lehessen inicializálni mind a három adat megadásával.
    //konstruktort definiálunk
    public Tanfolyam(String name, String description, Date appointment) {
        this.name = name;
        this.description = description;
        //dátumhoz használjuk a Calendar osztályt inkább
        Calendar cal = Calendar.getInstance();
        cal.setTime(appointment);
        this.appointment = cal.getTime();
    }

    public String getName() {
        return name;
    }

    //c.	Implementálja a tipizált Comparable tipizált interface-t úgy,
    // hogy az összehasonlítás alapja a név legyen.
    //Ha felül beírjuk, h "implements comparable<Tanfolyam>", akkor az IDE
    //automatikusan legenrálja ide a compareTo metódus vázát
    @Override
    public int compareTo(Tanfolyam o) {
        return this.name.compareTo(o.name);
    }

    //dátum formázáshoz
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    //d.	Legyen olyan metódusa, amely visszaadja az adatait szövegesen
    // ”Név, idõpont (rövid dátum és rövid idõ): leírás” alakban. (toString felüldefiniálás) (2p)
    @Override
    public String toString() {
        return this.name + ", " + df.format(appointment) + ": " + this.description ;
    }

    //e.	Legyen olyan metódusa, amely egy paraméterként megadott másik objektummal tartalmi egyezõséget vizsgál.
    // (equals felüldefiniálás) Akkor tekintsük egyenlõnek, ha a név adatuk megegyezik.
    //ezt az IDE legenerálja
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tanfolyam tanfolyam = (Tanfolyam) o;

        return name.equals(tanfolyam.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    //f.	Legyen olyan metódusa, amely paraméterként kap egy Date objektumot és visszaadja,
    // hogy a tanfolyam ugyanarra a hónapra esik-e, mint  a paraméterként megadott dátum. (2p)

    ////ha mûveleteket akarok végezni a dátummal,
    // akkor mindig át kell alakítani calendárrá,
    // ezért célszerû egy metódust létrehozni rá
    private Calendar getAppointmentCal(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public boolean isSameMonth(Date someDate){
        Calendar calSomeDate = getAppointmentCal(someDate);
        Calendar calThisDate = getAppointmentCal(this.appointment);
        return calSomeDate.get(Calendar.MONTH) == calThisDate.get(Calendar.MONTH);
    }

    //g.	Legyen olyan osztályszintû beágyazott osztálya, amely egy idõpont alapján mûködõ Comparator. (2p)
    public static class timeComparator implements Comparator<Tanfolyam>{

        @Override
        public int compare(Tanfolyam o1, Tanfolyam o2) {
            return o1.appointment.compareTo(o2.appointment);
        }
    }
}
