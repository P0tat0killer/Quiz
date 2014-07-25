package dominik.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

import dominik.quiz.R;

public class Start extends Activity {
    public static String loggedinUser;
    private Button start;
    private TextView richtig_text_view;
    private TextView falsche_text_view;
    private TextView Stats_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        richtig_text_view = (TextView) findViewById(R.id.richtig_text);
        falsche_text_view = (TextView) findViewById(R.id.falsch_text);
        Stats_view =  (TextView) findViewById(R.id.textView_Stats);

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setBackgroundColor(Color.RED);
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
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String a = prefs.getString("loggedinuser", "");
        Stats_view.setText("Statistik für " + a + ":");
        richtig_text_view.setText(prefs.getInt("user_" + a + "_richtig", 0) + " richtige Antworten");
        falsche_text_view.setText(prefs.getInt("user_" + a + "_falsch", 0) + " falsche Antworten");
    }

    @Override
    public void onResume() {
    super.onResume();
    Update();
    start.setBackgroundColor(Color.GRAY);
    }
}