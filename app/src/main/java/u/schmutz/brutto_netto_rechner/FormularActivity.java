package u.schmutz.brutto_netto_rechner;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

/*public class FormularActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);
    }
}*/

public class FormularActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);
    }
    public static final String BETRAG_KEY = "betrag";
    public static final String BETRAG_ART = "art";
    public static final String UST_PROZENT = "ust";

    public void onClickBerechnen(android.view.View button){
        // Betrag:
        // Hier ein Testeintrag nur für Git
        final EditText txtBetrag =
                (EditText) findViewById(R.id.edt_betrag);
        final String tmpBetrag =
                txtBetrag.getText().toString();
        float betrag = 0.0f;
        if (tmpBetrag.length()>0) {
            betrag = Float.parseFloat(tmpBetrag);
        }

        // Art des Betrags (Brutto, Netto):
        boolean isNetto = true;
        final RadioGroup rg =
                (RadioGroup) findViewById(R.id.rg_art);
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_art_netto:
                isNetto = true;
                break;
            case R.id.rb_art_brutto:
                break;
            default:

        }

        // Prozent Umsatzsteuer:
        // Neuer Eintrag für Git-Test-Lenovo
        // Neuer Eintrag für Git-Test-Asus
        final Spinner spinner =
                (Spinner) findViewById(R.id.sp_umsatzsteuer);
        final int pos = spinner.getSelectedItemPosition();
        final int[] prozentwerte =
                getResources().getIntArray(R.array.ust_werte);
        final int prozente = prozentwerte[pos];

        final Intent intent = new Intent(this,
                ErgebnisActivity.class);
        intent.putExtra(BETRAG_KEY,betrag);
        intent.putExtra(BETRAG_ART, isNetto);
        intent.putExtra(UST_PROZENT, prozentwerte);

        startActivity(intent);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.opt_beenden:
                finish();
                break;
                default:
        }
        return super.onOptionsItemSelected(item);
    }
}



