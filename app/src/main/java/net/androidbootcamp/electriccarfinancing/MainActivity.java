package net.androidbootcamp.electriccarfinancing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int intYears;
    int intLoan;
    float decDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText years = (EditText) findViewById(R.id.txtYears);
        final EditText loan = (EditText) findViewById(R.id.txtLoan);
        final EditText interest = (EditText) findViewById(R.id.txtInterest);
        Button button = (Button) findViewById(R.id.btnPayment);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intYears = Integer.parseInt(years.getText().toString());
                intLoan = Integer.parseInt(loan.getText().toString());
                decDecimal = Float.parseFloat(interest.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putInt("key1", intYears);
                editor.putInt("key2", intLoan);
                editor.putFloat("key3", decDecimal);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}
