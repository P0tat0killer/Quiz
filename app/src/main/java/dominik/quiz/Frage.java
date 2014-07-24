package dominik.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dominik on 24.07.2014.
 */
public class Frage {

    public static List<Frage> fragen = new ArrayList<Frage>();
    public static int Id;
    public static String Frage;
    public static String Richtige_Antwort;
    public static String Falsche_Antwort_1;
    public static String Falsche_Antwort_2;
    public static String Falsche_Antwort_3;
    public static String Thema;
    public static int Thema_Id;

    public Frage(int Id, String Frage, String Richtige_Antwort, String Falsche_Antwort_1, String Falsche_Antwort_2, String Falsche_Antwort_3, String Thema, int Thema_Id){
        this.Id = Id;
        this.Frage=Frage;
        this.Richtige_Antwort=Richtige_Antwort;
        this.Falsche_Antwort_1=Falsche_Antwort_1;
        this.Falsche_Antwort_2=Falsche_Antwort_2;
        this.Falsche_Antwort_3=Falsche_Antwort_3;
        this.Thema=Thema;
        this.Thema_Id=Thema_Id;
    }

    public static void addFragen(int Id,String Frage ,String Richtige_Antwort, String Falsche_Antwort_1, String Falsche_Antwort_2, String Falsche_Antwort_3, String Thema, int Thema_Id){
       Frage f = new Frage(Id, Frage,Richtige_Antwort, Falsche_Antwort_1,Falsche_Antwort_2,Falsche_Antwort_3,Thema,Thema_Id);
        fragen.add(f);
    }
    public static List<Frage> getFragenforThema(String Thema){
        List<Frage> FragenfuerThema = new ArrayList<dominik.quiz.Frage>();
      if(dominik.quiz.Thema.containsThema(Thema)){
          for(int i=0; i < fragen.size(); i++){
              if(fragen.get(i).getThema().equals(Thema)){
                  FragenfuerThema.add(FragenfuerThema.size() +1, fragen.get(i));
              }

          }
      }
        return FragenfuerThema;
    }

    public static Frage nextFrage(String Thema){
        if(dominik.quiz.Thema.containsThema(Thema)) {
            Random random = new Random();
            int size = getFragenforThema(Thema).size();
            int Fragerandom = random.nextInt(size);
            List<Frage> fragen_fuer_Thema = getFragenforThema(Thema);
            Frage f = fragen_fuer_Thema.get(Fragerandom);
            return f;
        }
        return null;
    }
    public static String getThema(){
        return Thema;
    }

  }
