package id.arieridwan.belajarlayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CoffeeActivity extends AppCompatActivity {
    EditText mTextNama;
    TextView mTextHarga, mTextQty;
    Button mButtonOrder, mButtonPlus, mButtonMin;
    RadioGroup taste;
    RadioButton sus, cholte;
    Context mContext;
    // spinner
    Spinner mSpinnerMenu;
    List<String> mListMenu = new ArrayList<>();
    int harga = 0;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        mContext=getApplication();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTextNama = (EditText) findViewById(R.id.mTextNama);
        mTextHarga = (TextView) findViewById(R.id.mTextHarga);
        mButtonOrder = (Button) findViewById(R.id.mButtonOrder);
        mTextQty = (TextView) findViewById(R.id.mTextQty);
        mButtonPlus = (Button) findViewById(R.id.mButtonPlus);
        mButtonMin = (Button) findViewById(R.id.mButtonMin);
        taste = (RadioGroup) findViewById(R.id.taste);
        sus = (RadioButton) findViewById(R.id.mSusu);
        cholte = (RadioButton) findViewById(R.id.mCholate);

        sus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "susu", Toast.LENGTH_SHORT).show();
            }
        });
        cholte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Cholate", Toast.LENGTH_SHORT).show();
            }
        });
        mSpinnerMenu = (Spinner) findViewById(R.id.mSpinnerMenu);
        mListMenu.add("-------");
        mListMenu.add("Martabak");
        mListMenu.add("Piscok Bakar");
        mListMenu.add("Ice Cream Sandwich");
        mListMenu.add("Lumpia Basah");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListMenu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMenu.setAdapter(dataAdapter);


//        mButtonOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Hi, nama saya "+mTextNama.getText(),Toast.LENGTH_LONG)
//                        .show();
//                mTextHarga.setText(mTextNama.getText());
//            }
//        });
    }

    public void onClickOrder(View view) {
//        Toast.makeText(getApplicationContext(),"Hi, nama saya "+mTextNama.getText(),Toast.LENGTH_LONG)
//                        .show();
//                mTextHarga.setText(mTextNama.getText());
    }

    public void onClickPlus(View view) {
        harga = harga + 5;
        qty = qty + 1;
        mTextQty.setText(qty + "");
        mTextHarga.setText("$" + harga);
    }

    public void onClickMin(View view) {
        if (harga != 0) {
            harga = harga - 5;
            qty = qty - 1;
            mTextQty.setText(qty + "");
            mTextHarga.setText("$" + harga);
        } else {
            harga = 0;
            qty = 0;
            mTextQty.setText(qty + "");
            mTextHarga.setText("$" + harga);
        }
    }

    public void onClickReset(View v) {
        harga = 0;
        qty = 0;
        mTextNama.setText("");
        mTextHarga.setText("$" + harga);
        mTextQty.setText(qty + "");
    }
public void onClickOrd(View v) {
        Log.i("Send email", "");

        String[] TO = {"someone@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.home)
        {onBackPressed();}
        return super.onOptionsItemSelected(item);
    }
}
