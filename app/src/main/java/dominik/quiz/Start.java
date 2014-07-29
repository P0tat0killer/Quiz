package dominik.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Start extends Activity {
    private Button start;
    private TextView richtig_text_view;
    private TextView falsche_text_view;
    private TextView Stats_view;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        richtig_text_view = (TextView) findViewById(R.id.richtig_text);
        falsche_text_view = (TextView) findViewById(R.id.falsch_text);
        Stats_view =  (TextView) findViewById(R.id.textView_Stats);
        web = (WebView) findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            }
        });
        web.loadUrl("https://github.com/meinusername/Quiz");
        NetworkInfo.State s = NetworkInfo.State.DISCONNECTED;
        if(s.equals(NetworkInfo.State.DISCONNECTED)){
            web.setVisibility(View.INVISIBLE);
        }

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
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Es gibt keine Einstellungen!", Toast.LENGTH_LONG).show();
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
        NetworkInfo.State s = NetworkInfo.State.CONNECTED;
            web.setVisibility(View.VISIBLE);
            web.loadUrl("https://elearning.izt.de/images/fragezeichen.png");
    }
}