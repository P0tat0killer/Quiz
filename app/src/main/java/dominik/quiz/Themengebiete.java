package dominik.quiz;

import android.database.Cursor;

import java.util.List;

/**
 * Created by Dominik on 23.07.2014.
 */
public class Themengebiete {

    private static Main main = new Main();
    private static Sql_datenbank sql = new Sql_datenbank(main);

    public static List<Themen> getListSize(){
        Cursor c =  sql.db_.rawQuery("SELECT * FROM Themengebiete " , new String[] { "" });
    }
}
