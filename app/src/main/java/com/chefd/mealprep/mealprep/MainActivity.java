package com.chefd.mealprep.mealprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private Button breakfastButton,lunchButton,dinnerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewsContentMain();
        setUpContentMainButtons();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Type of diet you have", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setUpContentMainButtons() {
        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Breakfast Options", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (MainActivity.this, Breakfast_Activity1.class);
                startActivity(intent);

            }
        });

        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Lunch Options", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (MainActivity.this, DietScreen_Activity.class);
                startActivity(intent);
            }
        });

        dinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Dinner Options", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (MainActivity.this, DietScreen_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void findViewsContentMain() {

        titleTextView = (TextView) findViewById(R.id.title_home_screen);
        breakfastButton = (Button) findViewById(R.id.breakfast);
        lunchButton = (Button) findViewById(R.id.lunch);
        dinnerButton = (Button) findViewById(R.id.dinner);

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
}