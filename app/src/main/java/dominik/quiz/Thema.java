package dominik.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominik on 24.07.2014.
 */
public class Thema {
    public static String Thema;
    public static List<Thema> Themen = new ArrayList<Thema>();

    public Thema(String Thema) {
        this.Thema = Thema;
    }

    public static int getThemaListSize() {
        return Themen.size();
    }

    public static void addThema(Thema t) {
        Themen.add(t);
    }

    public static int getId(String Thema) {
        if (containsThema(Thema)) {
            for (int i = 0; i < getThemaListSize(); i++) {
                if (Themen.get(i).equals(new Thema(Thema))) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static boolean containsThema(String Thema){
        boolean b = false;
        for(int i =0; i < getThemaListSize(); i++){
            if(Themen.get(i).equals(new Thema(Thema))){
                b=true;
                break;
            }
        }
        return b;
    }
    public static void reload(){
        Themen.clear();
        addThema(new Thema("Geographie"));
        addThema(new Thema("Politik"));
//        addThema(new Thema("Sport"));
//        addThema(new Thema("Geschichte"));
//        addThema(new Thema("Literatur"));
//        addThema(new Thema("Musik"));
//        addThema(new Thema("Wirtschaft"));
//        addThema(new Thema("Biologie"));
//        addThema(new Thema("Physik"));
    }
}
