package vizsga150529.feladat7;

/**
 * Created by weru8 on 2016. 11. 16..
 */
public enum MonitorSize {
    KICSI(8),
    KOZEPES(14),
    NAGY(21);

    private final int size;
    MonitorSize(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String toString(){
        String returnString;
        switch (this){
            case KICSI: returnString = "kicsi";
            break;
            case KOZEPES: returnString = "kozepes";
            break;
            case NAGY: returnString = "nagy";
            break;
            default: returnString = "";
        }
        return returnString;
    }

}
