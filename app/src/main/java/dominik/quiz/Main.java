package dominik.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Main extends Activity {

    Button start;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Frage.addFragen(Frage.fragen.size() +1, "Wie viele Bundesländer hat Deutschland?", "16", "15", "7", "18");
        Frage.addFragen(Frage.fragen.size() +1, "Wer war der Amerikanische Präsident 1990?", "George Bush", "Barak Obama", "Bill Clinton", "Ronald Reagan");
        Frage.addFragen(Frage.fragen.size() +1, "Wann ist die Titanik untergegangen?", "1912", "1818", "1860", "1960");
        Frage.addFragen(Frage.fragen.size() +1, "In welchem Land liegt Vancouver?", "Kanada", "USA", "Deutschland", "Japan");
        Frage.addFragen(Frage.fragen.size() +1, "Wo fand die Olympiade im Jahr 2000 statt?", "Australien", "Deutschland" , "Südafrika", "Brasilien");
        Frage.addFragen(Frage.fragen.size() +1, "Wer erfand die erste wirklich brauchbare Dampfmaschine?", "James Watt", "Albert Einstein", "Napoleon", "Isaac Newton");
        Frage.addFragen(Frage.fragen.size() +1, "Was ist eine Leier ?", "ein altes Zupfinstrument", "eine lange Wäscheleine", "ein Singvogel der Tropen" , "ein Pachtvertrag");
        Frage.addFragen(Frage.fragen.size() +1, "Welche US-amerikanische Stadt trägt den Beinamen Big Apple ?", "New York", "Dallas", "Chicago", "Los Angeles");
        Frage.addFragen(Frage.fragen.size() +1, "An welchem Fluss liegt München?", "Isar", "Neckar" , "Pegnitz", "Elbe");
        Frage.addFragen(Frage.fragen.size() +1, "Wie heißt die Insel Ceylon heute?", "Sri Lanka", "Goa", "Srinagar", "Siliguri");
        Frage.addFragen(Frage.fragen.size() +1, "Wofür benutzt man einen Fuchsschwanz?", "Sägen" ,"Angeln", "Hämmern", "Wildern");
        Frage.addFragen(Frage.fragen.size() +1, "Wie bezeichnet man Wirtschaft noch?", "Ökonomie","Ökologie","Ökotopie" ,"Ökotante");
        Frage.addFragen(Frage.fragen.size() +1, "Wer sagt: 'Dafür steh ich mit meinem Namen!'?", "Claus Hipp","Robert Koch", "Von Ardenne", "Kurt Felix");
        Frage.addFragen(Frage.fragen.size() +1, "Wovor fürchtet sich ein Klaustrophobe?", "Vor geschlossenen Räumen", "Vor Dieben und Räubern", "Vor Santa Claus", "Vor Prüfungen und Tests");
        Frage.addFragen(Frage.fragen.size() +1, "Wie viel Gramm sind ein Pfund?", "500", "100", "1000", "250");
        Frage.addFragen(Frage.fragen.size() +1, "Wer war Perikles?", "ein griechischer Staatsmann", "ein griechischer Philosoph", "ein römischer Feldherr", "ein römischer Dichter");
        Frage.addFragen(Frage.fragen.size() +1, "Was ist ein Mojito?", "Cocktail", "scharfe Soße", "spanischer Motorroller", "Insekt");
        Frage.addFragen(Frage.fragen.size() +1, "Wann blüht der Kakaobaum ?", "das ganze Jahr", "Sommer", "Herbst", "Frühling");
        Frage.addFragen(Frage.fragen.size() +1, "In welchem Land wurde Osama bin Laden geboren ?", "Saudi-Arabien", "Iran", "Oman", "Afghanistan");
        Frage.addFragen(Frage.fragen.size() +1, "Was ist das 'Nürnberger Ei'?", "Taschenuhr", "Fernmeldeturm", "Ovaler Lebkuchen", "Kleine Insel in der Pegnitz");
        Frage.addFragen(Frage.fragen.size() +1, "Was messen Schiffer in Faden?", "Wassertiefe", "Geschwindigkeit", "Länge des Bootes", "Breite des Bootes");
        Frage.addFragen(Frage.fragen.size() +1, "Wie viele Backofenbauer legten 1999 eine Gesellenprüfung ab ?", "keiner", "1230", "101", "54");
        Frage.addFragen(Frage.fragen.size() +1, "Wer war der erste Mensch im Weltraum?", "Juri Gagarin", "Neil Armstrong", "Peter Skribic", "Mike Webber");
        Frage.addFragen(Frage.fragen.size() +1, "Wie heißt das Buch von Dieter Bohlen?", "Nichts als die Wahrheit", "Das ist die Wahrheit", "Die wahre Geschichte", "Der Messias");
        Frage.addFragen(Frage.fragen.size() +1, "Wie hat sich Kurt Cobain (Nirvana) selbst ermordet?", "Er hat sich erschossen", "An einer Überdosis Rauschgift", "Tablettenmissbrauch", "Mit Autoabgasen erstickt");
        Frage.addFragen(Frage.fragen.size() +1, "Wie nennen die Berliner den Fernsehturm am Alexanderplatz?", "Telespargel", "Riesenwal", "Lange Latte", "Großer Heini");
        Frage.addFragen(Frage.fragen.size() +1, "Wer oder was ist Pinatubo ?", "ein Vulkan", "ein Cocktail", "ein Instrument", "eine Frucht");
        Frage.addFragen(Frage.fragen.size() +1, "Wen bezeichnet man als 'Pfeffersack'?", "Großkaufmann", "Kunstmäzen", "Reeder", "Imbisskoch");
        Frage.addFragen(Frage.fragen.size() +1, "Was bedeutet Netiquette?", "spezieller Knigge im Web", "Computerspiel", "Internetadresse", "Nettigkeit");
        Frage.addFragen(Frage.fragen.size() +1, "Wie heißt der Regisseur von 'Jurassic Park'?", "Steven Spielberg", "Stanley Kubrick", "Michael Herbig", "Bernd Eichinger");
        Frage.addFragen(Frage.fragen.size() +1, "Welches dieser EU-Länder hat die meisten Einwohner?", "Deutschland", "Frankreich", "Italien", "Vereinigtes Königreich");
        Frage.addFragen(Frage.fragen.size() +1, "Wer erfand den legendären C64-Computer?", "Commodore", "Atari", "Hewlett Packard", "Amiga");
        Frage.addFragen(Frage.fragen.size() +1, "Was wird in Beaufort gemessen?", "Windstärke", "Helligkeit", "Niederschlag", "Lawinengefahr");






        username= (EditText) findViewById(R.id.Username);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v == start) {
                    if (!username.getText().toString().equals("")) {
                        start.setBackgroundColor(Color.RED);
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("loggedinuser", username.getText().toString());
                        editor.commit();
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(), Start.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Du musst einen Usernamen eingeben!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(getApplicationContext(), "Es gibt keine Einstellungen!" ,Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
    public void onResume(){
        super.onResume();
        start.setBackgroundColor(Color.GRAY);
    }
}
