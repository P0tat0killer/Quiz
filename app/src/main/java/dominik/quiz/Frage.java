package dominik.quiz;

import android.app.AlertDialog;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Dominik on 24.07.2014.
 */
public class Frage {

    static public class Antwort {
        public boolean richtige;
        public String text;
        public Antwort(boolean richtige, String text) {
            this.richtige = richtige;
            this.text = text;
        }
    }

    public static List<Frage> fragen = new ArrayList<Frage>();

    public int Id;
    public String Frage;

    public List<Antwort> Antworten = new ArrayList<Antwort>();

    public Frage(int Id, String Frage, String Richtige_Antwort, String Falsche_Antwort_1, String Falsche_Antwort_2, String Falsche_Antwort_3){
        this.Id = Id;
        this.Frage=Frage;

        Antworten.add(new Antwort(true, Richtige_Antwort));
        Antworten.add(new Antwort(false, Falsche_Antwort_1));
        Antworten.add(new Antwort(false, Falsche_Antwort_2));
        Antworten.add(new Antwort(false, Falsche_Antwort_3));

        shuffle();
        System.out.print(Antworten.toString());
        System.out.print(Antworten.toArray());
    }

    public static void addFragen(int Id,String Frage ,String Richtige_Antwort, String Falsche_Antwort_1, String Falsche_Antwort_2, String Falsche_Antwort_3){
       Frage f = new Frage(Id, Frage,Richtige_Antwort, Falsche_Antwort_1,Falsche_Antwort_2,Falsche_Antwort_3);
        fragen.add(f);
    }

    public void shuffle(){
        Collections.shuffle(Antworten);
    }

    public static void shuffleAll(){
        for (int i = 0; i < fragen.size(); ++i) {
            fragen.get(i).shuffle();
        }
    }

    public static Frage nextFrage(){
            int i = randInt(0, fragen.size()-1);
            Log.d("Random", i + "");
            Frage f = fragen.get(i);
            return f;
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


    public String getRichtigeAntwort(){
        for (int i = 0; i < Antworten.size(); ++i) {
            Antwort a = Antworten.get(i);
            if (a.richtige) {
                return a.text;
            }
        }
        return "";
    }

    public String getFrage(){ return Frage; }

    public List<Antwort> getAntworten(){
        return Antworten;
    }
  }
