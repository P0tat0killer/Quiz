package dominik.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Main extends Activity {

    Button BTN_ANTWORT_A;
    Button BTN_ANTWORT_B;
    Button BTN_ANTWORT_C;
    Button BTN_ANTWORT_D;
    Sql_datenbank sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sql = new Sql_datenbank(this);
         BTN_ANTWORT_A = (Button) findViewById(R.id.Antwort_A);
        BTN_ANTWORT_B = (Button) findViewById(R.id.Antwort_B);
        BTN_ANTWORT_C = (Button) findViewById(R.id.Antwort_C);
        BTN_ANTWORT_D =  (Button) findViewById(R.id.Andwort_D);

        BTN_ANTWORT_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == BTN_ANTWORT_A){

                }
            }
        });
        BTN_ANTWORT_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == BTN_ANTWORT_B){

                }
            }
        });
        BTN_ANTWORT_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == BTN_ANTWORT_C){

                }
            }
        });
        BTN_ANTWORT_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == BTN_ANTWORT_D){

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
