package vizsga150529.feladat6;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by weru8 on 2016. 11. 16..
 */
public class MapFeladat {
    public static void main(String[] args) {
        //a TreeMap rendezett Map
        Map myMap = new TreeMap<String, Integer>();
        myMap.put("Kiss János", 5);
        myMap.put("Nagy Béla", 3);
        myMap.put("Kocsis Imre", 4);
        myMap.put("Joo János", 5);

        //Iterátor létrehozása adatok kiírásához
        Set set = myMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            System.out.println(mapEntry.getKey() + ": " + mapEntry.getValue());
        }



    }
}
