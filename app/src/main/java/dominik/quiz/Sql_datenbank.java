package dominik.quiz;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dominik on 23.07.2014.
 */
public class Sql_datenbank extends SQLiteOpenHelper {

    private static String DB_NAME = "myDatabase.db";
    private static SQLiteDatabase db_;



    public Sql_datenbank(Activity context){
        super(context, DB_NAME, null, 3);
        db_ = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE Fragen( _id integer primary key autoincrement, Frage text not null, Richtige_Antwort integer, A1_id integer, A2_id integer, A3_id integer, A4_id integer, Schwierigkeitsgrad integer);");
        db.execSQL("CREATE TABLE Themengebiete (_id integer primary key autoincrement, Thema text not null);");
        db.execSQL("CREATE TABLE Antworten (_id integer primary key autoincrement, Antwort text not null);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Fragen");
        db.execSQL("drop table if exists Themengebiete");
        db.execSQL("drop table if exists Antworten");
        onCreate(db);

    }

}
