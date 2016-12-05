package com.chefd.mealprep.mealprep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class CaloriesCalculatorActivity extends AppCompatActivity {

    private Button submitButton;
    private Button calorieviewButton;
    private EditText editAge;
    private EditText editWeight;
    private EditText editHeightf;
    private EditText editHeighti;
    private TextView textResults;
    private CheckBox fcheckBox;
    private CheckBox mcheckBox;
    private double result;
    private int sex;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_calc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setContentViews
        findViewsContentMain();
        setUpContentButtons();

        // this makes sure that the keyboard doesn't push the layout up
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        // makes sure the activity stays in portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Button that when clicked will display results of BMR calcualtion
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                makeCalculations();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    } //end of on create method

    //onclick listener for submit button
    private void setUpContentButtons() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
            }
        });
        calorieviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(CaloriesCalculatorActivity.this,
                                CalorieViewActivity.class);
                startActivity(intent);
            }
        });
    } // end of setUpContentButton

    private void makeCalculations() {
        // Gather Numbers
        if (editAge.getText().toString().equals("")
                || editHeightf.getText().toString().equals("")
                || editHeighti.getText().toString().equals("")
                || editWeight.getText().toString().equals("")) {
            Toast.makeText(this, "You are missing an entry, Please Complete",
                    Toast.LENGTH_LONG).show();
            return;
        } else {

            double age = Double.valueOf(editAge.getText().toString());
            double heightF = Double.valueOf(editHeightf.getText().toString());
            double heightI = Double.valueOf(editHeighti.getText().toString());
            double weight = Double.valueOf(editWeight.getText().toString());


            double heightIn;
            //math for height feet and inches call it heightin
            heightIn = (heightF * 12) + heightI;

            //varify if entries are resonable
            if (age > 150 || age < 1) {
                Toast.makeText(this, "Drop this app now and go talk to someone. "
                                + "You are older than any man/woman in recorded history.",
                        Toast.LENGTH_LONG).show();
                return;
            } else if (heightIn > 160 || heightIn < 5) {
                Toast.makeText(this, "Height is not humanly possible",
                        Toast.LENGTH_LONG).show();
                return;
            } else if (weight > 3000) {
                Toast.makeText(this, "CHILL BRUH, YOU NOT THAT HEAVY!!",
                        Toast.LENGTH_LONG).show();
                return;
            }

            double weightK;
            double heightCm;

            weightK = weight / 2.2;  // weight from pounds to kilograms
            heightCm = heightIn * 2.54; //height from inches to centimeters

            //calculating BMR based on sex
            if (sex == 1) {  //equation for females
                if (editAge.equals("")
                        || editHeightf.equals("")
                        || editHeighti.equals("")
                        || editWeight.equals("")) {
                    result = 0;
                    Toast.makeText(this, "You are missing an entry, Please Complete",
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    result = (665.09 + (9.56 * weightK)
                            + (1.84 * heightCm) - (4.67 * age));
                }
            } else {       //equation for male
                if (editAge.equals("")
                        || editHeightf.equals("")
                        || editHeighti.equals("")
                        || editWeight.equals("")) {
                    result = 0;
                    Toast.makeText(this, "You are missing an entry, Please Complete",
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    result = (66.47 + (13.75 * weightK)
                            + (5.0 * heightCm) - (6.75 * age));
                }
            }
            textResults.setText("Minimum Calories Per Day: " + (int) result);
        }
    }

    //Checkbox on click listener
    public void onCheckboxClicked(View view) { // Is the view now checked
        boolean checked = ((CheckBox) view).isChecked();// Check which checkbox was clicked
        switch (view.getId()) {
          case R.id.fcheckBox:
              if (checked) {
                  sex = 1;
                  fcheckBox.setChecked(true);
                  mcheckBox.setChecked(false);
              } else {
                  sex = 2;
                  mcheckBox.setChecked(true);
                  fcheckBox.setChecked(false);
              }
              break;
          case R.id.mcheckBox:
              if (checked) {
                  sex = 2;
                  mcheckBox.setChecked(true);
                  fcheckBox.setChecked(false);
              } else {
                  sex = 1;
                  fcheckBox.setChecked(true);
                  mcheckBox.setChecked(false);
              }
              break;
          default:
              return;
        }
    }

    private void findViewsContentMain() {
        editAge = (EditText) findViewById(R.id.editAge);
        editHeightf = (EditText) findViewById(R.id.editHeightf);
        editHeighti = (EditText) findViewById(R.id.editHeighti);
        editWeight = (EditText) findViewById(R.id.editWeight);
        textResults = (TextView) findViewById(R.id.textResults);
        submitButton = (Button) findViewById(R.id.submitButton);
        mcheckBox = (CheckBox) findViewById(R.id.mcheckBox);
        fcheckBox = (CheckBox) findViewById(R.id.fcheckBox);
        calorieviewButton = (Button) findViewById(R.id.calorieviewButton);
    }


    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("CaloriesCalculator Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
} //end of class