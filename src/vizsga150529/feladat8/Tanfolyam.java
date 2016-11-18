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
    //a.	Tudja t�rolni egy tanfolyam nev�t (sz�veg), le�r�s�t (sz�veg), id�pontj�t (d�tum �s id�) (Date).
    private String name;
    private String description;
    private Date appointment;

    //b.	Lehessen inicializ�lni mind a h�rom adat megad�s�val.
    //konstruktort defini�lunk
    public Tanfolyam(String name, String description, Date appointment) {
        this.name = name;
        this.description = description;
        //d�tumhoz haszn�ljuk a Calendar oszt�lyt ink�bb
        Calendar cal = Calendar.getInstance();
        cal.setTime(appointment);
        this.appointment = cal.getTime();
    }

    public String getName() {
        return name;
    }

    //c.	Implement�lja a tipiz�lt Comparable tipiz�lt interface-t �gy,
    // hogy az �sszehasonl�t�s alapja a n�v legyen.
    //Ha fel�l be�rjuk, h "implements comparable<Tanfolyam>", akkor az IDE
    //automatikusan legenr�lja ide a compareTo met�dus v�z�t
    @Override
    public int compareTo(Tanfolyam o) {
        return this.name.compareTo(o.name);
    }

    //d�tum form�z�shoz
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    //d.	Legyen olyan met�dusa, amely visszaadja az adatait sz�vegesen
    // �N�v, id�pont (r�vid d�tum �s r�vid id�): le�r�s� alakban. (toString fel�ldefini�l�s) (2p)
    @Override
    public String toString() {
        return this.name + ", " + df.format(appointment) + ": " + this.description ;
    }

    //e.	Legyen olyan met�dusa, amely egy param�terk�nt megadott m�sik objektummal tartalmi egyez�s�get vizsg�l.
    // (equals fel�ldefini�l�s) Akkor tekints�k egyenl�nek, ha a n�v adatuk megegyezik.
    //ezt az IDE legener�lja
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

    //f.	Legyen olyan met�dusa, amely param�terk�nt kap egy Date objektumot �s visszaadja,
    // hogy a tanfolyam ugyanarra a h�napra esik-e, mint  a param�terk�nt megadott d�tum. (2p)

    ////ha m�veleteket akarok v�gezni a d�tummal,
    // akkor mindig �t kell alak�tani calend�rr�,
    // ez�rt c�lszer� egy met�dust l�trehozni r�
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

    //g.	Legyen olyan oszt�lyszint� be�gyazott oszt�lya, amely egy id�pont alapj�n m�k�d� Comparator. (2p)
    public static class timeComparator implements Comparator<Tanfolyam>{

        @Override
        public int compare(Tanfolyam o1, Tanfolyam o2) {
            return o1.appointment.compareTo(o2.appointment);
        }
    }
}
