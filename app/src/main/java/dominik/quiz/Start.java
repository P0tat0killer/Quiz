package dominik.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;

import dominik.quiz.R;

public class Start extends Activity {
    public static String loggedinUser;
    private Button start;
    private TextView richtig_text_view;
    private TextView falsche_text_view;
    private TextView Stats_view;
    private Button up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        loggedinUser = prefs.getString("loggedinuser" , "");
        richtig_text_view = (TextView) findViewById(R.id.richtig_text);
        falsche_text_view =  (TextView) findViewById(R.id.falsch_text);
        Stats_view =  (TextView) findViewById(R.id.textView_Stats);
        up = (Button) findViewById(R.id.update);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update();
            }
        });
        String a = prefs.getString("loggedinuser", "");
        Stats_view.setText("Statistik für " + a + ":");
        richtig_text_view.setText(prefs.getInt("user_" + a + "_richtig", 0) + " richtige Antworten");
        falsche_text_view.setText(prefs.getInt("user_" + a + "_falsch", 0) + " falsche Antworten");
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frage.shuffleAll();
                Intent intent = new Intent(getApplicationContext() , Fragen_Seite.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
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
    public void Update(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String a = prefs.getString("loggedinuser", "");
        richtig_text_view.setText(prefs.getInt("user_" + a + "_richtig", 0) + " richtige Antworten");
        falsche_text_view.setText(prefs.getInt("user_" + a + "_falsch", 0) + " falsche Antworten");
    }

}
