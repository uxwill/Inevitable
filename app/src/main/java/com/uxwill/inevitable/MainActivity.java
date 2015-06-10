package com.uxwill.inevitable;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CHOOSE = 1234;
    private int humans_count = 50;
    private int android_count = 50;
    private int number = 0;

    private String[][] qrs =
            {
                    {"1", "http://qrs.ly/e34qr5l"},
                    {"2", "http://qrs.ly/5b4qr5m"},
                    {"3", "http://qrs.ly/c64qr5n"},
                    {"4", "http://qrs.ly/v64qr5o"},
                    {"5", "http://qrs.ly/yd4qr5p"},
                    {"6", "http://qrs.ly/a34qr5q"},
                    {"7", "http://qrs.ly/5l4qr5r"},
                    {"8", "http://qrs.ly/ui4qr5s"},
                    {"9", "http://qrs.ly/eq4qr5t"},
                    {"10", "http://qrs.ly/jo4qr5u"},
                    {"11", "http://qrs.ly/zd4qr5v"},
                    {"12", "http://qrs.ly/xj4qr5w"},
                    {"13", "http://qrs.ly/xt4qr5x"},
                    {"14", "http://qrs.ly/8y4qr5y"},
                    {"15", "http://qrs.ly/sj4qr5z"},
                    {"16", "http://qrs.ly/8k4qr60"},
                    {"17", "http://qrs.ly/wi4qr61"},
                    {"18", "http://qrs.ly/j34qr62"},
                    {"19", "http://qrs.ly/aq4qr63"},
                    {"20", "http://qrs.ly/s34qr64"},
                    {"21", "http://qrs.ly/br4qr65"},
                    {"22", "http://qrs.ly/ew4qr66"},
                    {"23", "http://qrs.ly/ye4qr67"},
                    {"24", "http://qrs.ly/n74qr68"},
                    {"25", "http://qrs.ly/m74qr69"},
                    {"26", "http://qrs.ly/bj4qr6a"},
                    {"27", "http://qrs.ly/y44qr6b"},
                    {"28", "http://qrs.ly/lj4qr6c"},
                    {"29", "http://qrs.ly/6m4qr6d"},
                    {"30", "http://qrs.ly/wx4qr6e"},
                    {"31", "http://qrs.ly/uu4qr6f"},
                    {"32", "http://qrs.ly/mn4qr6g"},
                    {"33", "http://qrs.ly/mf4qr6h"},
                    {"34", "http://qrs.ly/yp4qr6i"},
                    {"35", "http://qrs.ly/if4qr6j"},
                    {"36", "http://qrs.ly/8m4qr6k"},
                    {"37", "http://qrs.ly/gb4qr6l"},
                    {"38", "http://qrs.ly/7g4qr6m"},
                    {"39", "http://qrs.ly/424qr6n"},
                    {"40", "http://qrs.ly/dx4qr6o"},
                    {"41", "http://qrs.ly/724qr6p"},
                    {"42", "http://qrs.ly/xo4qr6q"},
                    {"43", "http://qrs.ly/dx4qr6r"},
                    {"44", "http://qrs.ly/344qr6s"},
                    {"45", "http://qrs.ly/ot4qr6u"},
                    {"46", "http://qrs.ly/s44qr6v"},
                    {"47", "http://qrs.ly/hb4qr6w"},
                    {"48", "http://qrs.ly/gk4qr6x"},
                    {"49", "http://qrs.ly/o14qr6y"},
                    {"50", "http://qrs.ly/yk4qr6z"},
                    {"51", "http://qrs.ly/i14qr70"},
                    {"52", "http://qrs.ly/z14qr71"},
                    {"53", "http://qrs.ly/qd4qr72"},
                    {"54", "http://qrs.ly/hi4qr73"},
                    {"55", "http://qrs.ly/z34qr74"},
                    {"56", "http://qrs.ly/8x4qr75"},
                    {"57", "http://qrs.ly/fj4qr76"},
                    {"58", "http://qrs.ly/cc4qr77"},
                    {"59", "http://qrs.ly/ro4qr78"},
                    {"60", "http://qrs.ly/sn4qr79"},
                    {"61", "http://qrs.ly/ag4qr7a"},
                    {"62", "http://qrs.ly/w94qr7b"},
                    {"63", "http://qrs.ly/xp4qr7c"},
                    {"64", "http://qrs.ly/lv4qr7d"},
                    {"65", "http://qrs.ly/6w4qr7e"},
                    {"66", "http://qrs.ly/a44qr7f"},
                    {"67", "http://qrs.ly/lw4qr7g"},
                    {"68", "http://qrs.ly/ka4qr7h"},
                    {"69", "http://qrs.ly/2v4qr7i"},
                    {"70", "http://qrs.ly/w14qr7j"},
                    {"71", "http://qrs.ly/w14qr7k"},
                    {"72", "http://qrs.ly/2h4qr7l"},
                    {"73", "http://qrs.ly/yf4qr7m"},
                    {"74", "http://qrs.ly/f94qr7n"},
                    {"75", "http://qrs.ly/494qr7o"},
                    {"76", "http://qrs.ly/kb4qr7p"},
                    {"77", "http://qrs.ly/n84qr7q"},
                    {"78", "http://qrs.ly/g24qr7r"},
                    {"79", "http://qrs.ly/vd4qr7s"},
                    {"80", "http://qrs.ly/h44qr7t"},
                    {"81", "http://qrs.ly/474qr7u"},
                    {"82", "http://qrs.ly/v34qr7v"},
                    {"83", "http://qrs.ly/zw4qr7w"},
                    {"84", "http://qrs.ly/wf4qr7x"},
                    {"85", "http://qrs.ly/n74qr7y"},
                    {"86", "http://qrs.ly/cj4qr7z"},
                    {"87", "http://qrs.ly/do4qr80"},
                    {"88", "http://qrs.ly/x64qr81"},
                    {"89", "http://qrs.ly/ed4qr82"},
                    {"90", "http://qrs.ly/7b4qr83"},
                    {"91", "http://qrs.ly/hq4qr84"},
                    {"92", "http://qrs.ly/vo4qr85"},
                    {"93", "http://qrs.ly/hd4qr86"},
                    {"94", "http://qrs.ly/aq4qr87"},
                    {"95", "http://qrs.ly/y34qr88"},
                    {"96", "http://qrs.ly/n74qr89"},
                    {"97", "http://qrs.ly/ce4qr8a"},
                    {"98", "http://qrs.ly/gq4qr8b"},
                    {"99", "http://qrs.ly/h14qr8c"},
                    {"100", "http://qrs.ly/x44qr8d"},
                    {"101", "http://qrs.ly/jh4qr8e"},
                    {"102", "http://qrs.ly/nm4qr8f"},
                    {"103", "http://qrs.ly/ap4qr8g"},
                    {"104", "http://qrs.ly/7b4qr8h"},
                    {"105", "http://qrs.ly/5s4qr8i"},
                    {"106", "http://qrs.ly/e14qr8j"},
                    {"107", "http://qrs.ly/9e4qr8k"},
                    {"108", "http://qrs.ly/dt4qr8l"},
                    {"109", "http://qrs.ly/hf4qr8m"},
                    {"110", "http://qrs.ly/rg4qr8n"},
                    {"111", "http://qrs.ly/yj4qr8o"},
                    {"112", "http://qrs.ly/ti4qr8p"},
                    {"113", "http://qrs.ly/c44qr8q"},
                    {"114", "http://qrs.ly/d14qr8r"},
                    {"115", "http://qrs.ly/i14qr8s"},
                    {"116", "http://qrs.ly/7q4qr8t"},
                    {"117", "http://qrs.ly/c44qr8u"},
                    {"118", "http://qrs.ly/oq4qr8v"},
                    {"119", "http://qrs.ly/2l4qr8w"},
                    {"120", "http://qrs.ly/mj4qr8x"},
                    {"121", "http://qrs.ly/ou4qr8y"},
                    {"122", "http://qrs.ly/9l4qr8z"},
                    {"123", "http://qrs.ly/p24qr90"},
                    {"124", "http://qrs.ly/444qr91"},
                    {"125", "http://qrs.ly/g54qr92"},
                    {"126", "http://qrs.ly/pn4qr93"},
                    {"127", "http://qrs.ly/534qr94"},
                    {"128", "http://qrs.ly/lw4qr95"},
                    {"129", "http://qrs.ly/do4qr96"},
                    {"130", "http://qrs.ly/vv4qr97"},
                    {"131", "http://qrs.ly/y34qr98"},
                    {"132", "http://qrs.ly/pm4qr99"},
                    {"133", "http://qrs.ly/u64qr9a"},
                    {"134", "http://qrs.ly/jf4qr9b"},
                    {"135", "http://qrs.ly/464qr9c"},
                    {"136", "http://qrs.ly/zr4qr9d"},
                    {"137", "http://qrs.ly/kg4qr9e"},
                    {"138", "http://qrs.ly/f94qr9f"},
                    {"139", "http://qrs.ly/dy4qr9g"},
                    {"140", "http://qrs.ly/6t4qr9h"},

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void scan(View view)
    {
        Intent data = new Intent("com.google.zxing.client.android.SCAN");
        data.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(data, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                String url = data.getStringExtra("SCAN_RESULT");

                RequestQueue queue = Volley.newRequestQueue(this);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                number = Integer.parseInt(response);

                                Intent intent;
                                if (number > 110)
                                {
                                    intent = new Intent(MainActivity.this, QuoteActivity.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    intent = new Intent(MainActivity.this, ChoiceActivity.class);
                                    startActivityForResult(intent, REQUEST_CHOOSE);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // Handle error
                            }
                        });
                queue.add(stringRequest);



            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
        else if (requestCode == REQUEST_CHOOSE)
        {
            if (resultCode == RESULT_OK)
            {
                int choice = data.getIntExtra("choice", 0);

                if (choice == 0) // kill
                {
                    if (number % 2 == 0)
                    {
                        humans_count -= 1;
                    }
                    else
                    {
                        android_count -= 1;
                    }
                }
                else // save
                {
                    if (number % 2 == 0)
                    {
                        humans_count += 1;
                    }
                    else
                    {
                        android_count += 1;
                    }
                }
            }
        }
    }
}
