package com.chefd.mealprep.mealprep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CaloriesCalculatorActivity extends AppCompatActivity {

    private Button submitButton;
    private Button calorieviewButton;
    private EditText editAge;
    private EditText editWeight;
    private EditText editHeight;
    private TextView textResults;
    private CheckBox fcheckBox;
    private CheckBox mcheckBox;
    private double result;
    private int sex;


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
                || editHeight.getText().toString().equals("")
                || editWeight.getText().toString().equals("")) {
            Toast.makeText(this, "You are missing an entry, Please Complete",
                    Toast.LENGTH_LONG).show();
            return;
        } else {


            double age = Double.valueOf(editAge.getText().toString());
            double height = Double.valueOf(editHeight.getText().toString());
            double weight = Double.valueOf(editHeight.getText().toString());

            double weightK;
            double heightCm;

            weightK = weight / 2.2;  // weight from pounds to kilograms
            heightCm = height * 2.54; //height from inches to centimeters

            //calculating BMR based on sex
            if (sex == 1) {  //equation for females
                if (editAge.equals("") || editHeight.equals("") || editWeight.equals("")) {
                    result = 0;
                    Toast.makeText(this, "You are missing an entry, Please Complete",
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    result = 665.09 + (9.56 * weightK) + (1.84 * heightCm) - (4.67 * age);
                }
            } else {       //equation for male
                if (editAge.equals("") || editHeight.equals("") || editWeight.equals("")) {
                    result = 0;
                    Toast.makeText(this, "You are missing an entry, Please Complete",
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    result = 66.47 + (13.75 * weightK) + (5.0 * heightCm) - (6.75 * age);
                }
            }
            textResults.setText("Minimum Calories Per Day: " + (int) result);
        }
    }

    //Checkbox on click listner

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
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
        editHeight = (EditText) findViewById(R.id.editHeight);
        editWeight = (EditText) findViewById(R.id.editWeight);
        textResults = (TextView) findViewById(R.id.textResults);
        submitButton = (Button) findViewById(R.id.submitButton);
        mcheckBox = (CheckBox) findViewById(R.id.mcheckBox);
        fcheckBox = (CheckBox) findViewById(R.id.fcheckBox);
        calorieviewButton = (Button) findViewById(R.id.calorieviewButton);

    }


} //end of class