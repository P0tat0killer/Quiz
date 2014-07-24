package dominik.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Main extends Activity {

    Button start;
    EditText username;
    Sql_datenbank sql;
    public static List<Thema> themen = new ArrayList<Thema>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thema.reload();
        Frage.addFragen(Frage.fragen.size() + 1, "Wie viele Bundesländer hat Deutschland?", "16", "15", "7", "18", "Geographie", Thema.getId("Geographie"));
        Frage.addFragen(Frage.fragen.size() +1, "Wer war der Amerikanische Präsident 1990?" , "George Bush", "Barak Obama", "Bill Clinton", "Ronald Reagan", "Politik", Thema.getId("Politik"));
        sql = new Sql_datenbank(this);
        username= (EditText) findViewById(R.id.Username);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == start) {
                    if (!username.getText().toString().equals("")) {
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("loggedinuser", username.getText().toString());
                        editor.commit();
                        Intent intent = new Intent(getApplicationContext(), Start.class);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Du musst einen Username eingeben", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
