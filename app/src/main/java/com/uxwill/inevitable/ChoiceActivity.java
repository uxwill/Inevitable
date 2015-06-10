package com.uxwill.inevitable;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class ChoiceActivity extends ActionBarActivity {
    private int[] humans =
            {
                R.string.human1,
                R.string.human2
            };

    private int[] androids =
            {
                    R.string.android1,
                    R.string.android2
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Random random = new Random(System.currentTimeMillis());
        int type = getIntent().getIntExtra("type", 0);

        TextView txt_quote = (TextView)findViewById(R.id.txt_saying);

        if (type == 0) // humans
        {
            txt_quote.setText(humans[random.nextInt(humans.length)]);
        }
        else if (type == 1) // androids
        {
            txt_quote.setText(androids[random.nextInt(androids.length)]);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scan, menu);
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

    public void save(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("choice", 1);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void kill(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("choice", 0);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
