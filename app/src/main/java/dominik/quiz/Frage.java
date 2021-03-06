package dominik.quiz;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
    public Boolean answered = false;

    public List<Antwort> Antworten = new ArrayList<Antwort>();
    public static Set<Integer> beantwortetefragen = new HashSet<Integer>();

    public Frage(int Id, String Frage, String Richtige_Antwort, String Falsche_Antwort_1, String Falsche_Antwort_2, String Falsche_Antwort_3){
        this.Id = Id;
        this.Frage=Frage;

        Antworten.add(new Antwort(true, Richtige_Antwort));
        Antworten.add(new Antwort(false, Falsche_Antwort_1));
        Antworten.add(new Antwort(false, Falsche_Antwort_2));
        Antworten.add(new Antwort(false, Falsche_Antwort_3));

        shuffle();
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

    public static Frage nextFrage(Activity activity){
        if (beantwortetefragen.size() == fragen.size()) {
            beantwortetefragen.clear();

            Toast.makeText(activity, "Neue Runde", Toast.LENGTH_LONG).show();
        }

       while (true) {
           int i = randInt(0, fragen.size()-1);
           Log.d("Random", i + "");
           Frage f = fragen.get(i);
           if(!beantwortetefragen.contains(f.Id)){
               beantwortetefragen.add(f.Id);
               return f;
           }
       }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
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