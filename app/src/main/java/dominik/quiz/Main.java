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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Frage.addFragen(Frage.fragen.size() +1, "Wie viele Bundesländer hat Deutschland?", "16", "15", "7", "18");
        Frage.addFragen(Frage.fragen.size() +1 , "Wer war der Amerikanische Präsident 1990?" , "George Bush", "Barak Obama", "Bill Clinton", "Ronald Reagan");
        Frage.addFragen(Frage.fragen.size() +1 , "Wann ist die Titanik untergegangen?" , "1912", "1818", "1860", "1960");
        Frage.addFragen(Frage.fragen.size() +1, "In welchem Land liegt Vancouver?", "Kanada" , "USA", "Deutschland", "Japan");
        Frage.addFragen(Frage.fragen.size() +1, "Wo fand die Olympiade im Jahr 2000 statt?", "Australien", "Deutschland" , "Südafrika", "Brasilien");
        Frage.addFragen(Frage.fragen.size() +1, "Wer erfand die  erste wirklich brauchbare Dampfmaschine?", "James Watt", "Albert Einstein", "Napoleon", "Isaac Newton");
        Frage.addFragen(Frage.fragen.size() +1, "Was ist eine Leier ?", "ein altes Zupfinstrument", "eine lange Wäscheleine", "ein Singvogel der Tropen" , "ein Pachtvertrag");
        Frage.addFragen(Frage.fragen.size() +1 , "Welche US-amerikanische Stadt trägt den Beinamen Big Apple ?", "New York", "Dallas", "Chicago", "Los Angeles");
        Frage.addFragen(Frage.fragen.size() +1 , "An welchem Fluss liegt München?", "Isar", "Neckar" , "Pegnitz", "Elbe");
        Frage.addFragen(Frage.fragen.size() +1, "Wie heißt die Insel Ceylon heute?", "Sri Lanka", "Goa", "Srinagar", "Siliguri");
        Frage.addFragen(Frage.fragen.size() +1, "Wofür benutzt man einen Fuchsschwanz?" , "Sägen" ,"Angeln" , "Hämmern", "Wildern");
        Frage.addFragen(Frage.fragen.size() +1, "Wie bezeichnet man Wirtschaft noch?", "Ökonomie","Ökologie" ,"Ökotopie" ,"Ökotante");
        Frage.addFragen(Frage.fragen.size() +1 , "Wer sagt: 'Dafür steh ich mit meinem Namen!'?", "Claus Hipp" ,"Robert Koch" , "Von Ardenne", "Kurt Felix");
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
