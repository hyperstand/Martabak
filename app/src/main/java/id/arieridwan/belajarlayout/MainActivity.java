package id.arieridwan.belajarlayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMe(View view) {
        Intent x = new Intent(MainActivity.this, CoffeeActivity.class);
        startActivity(x);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent about = new Intent(MainActivity.this, ActivityProfile.class);
                startActivity(about);          //TODO pindah ke halaman profile activity
                break;
            case R.id.order:
                Intent order = new Intent(MainActivity.this, CoffeeActivity.class);
                startActivity(order);
                break;
            case R.id.quit:
                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setTitle("Do You want to quit");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit =builder.create();
                quit.show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
