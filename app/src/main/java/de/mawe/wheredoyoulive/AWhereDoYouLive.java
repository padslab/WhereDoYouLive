package de.mawe.wheredoyoulive;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AWhereDoYouLive extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awhere_do_you_live);

        final EditText addressfield =
                (EditText) findViewById(R.id.address);
        final Button button = (Button)
                findViewById(R.id.launchmap);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    String address;
                    address = addressfield.getText().toString();
                    address = address.replace(' ', '+');
                    Intent geoIntent = new Intent
                            (android.content.Intent.ACTION_VIEW,
                                    Uri.parse("http://maps.google.com/maps?q=" + address));

                    startActivity(geoIntent);
                } catch (Exception e) {
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_awhere_do_you_live, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
