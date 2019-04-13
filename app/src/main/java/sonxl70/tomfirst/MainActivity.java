package sonxl70.tomfirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        EditText etZaehler = findViewById(R.id.zaehler);
        EditText etNenner = findViewById(R.id.nenner);
        int z = Integer.parseInt(etZaehler.getText().toString());
        int n = Integer.parseInt(etNenner.getText().toString());

        if (z*n != 0) {
            int rest;
            int ggt = Math.abs(z);
            int divisor = Math.abs(n);
            do {
                rest = ggt % divisor;
                ggt = divisor;
                divisor = rest;
            } while (rest > 0);
            z /= ggt;
            n /= ggt;
            etZaehler.setText(Integer.toString(z));
            etNenner.setText(Integer.toString(n));
        }
   }
}
