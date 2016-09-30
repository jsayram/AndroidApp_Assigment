package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//MODIFIED FIRST MEAL FRAGMENT
public class My_Breakfast_meal_Frag1 extends Fragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static My_Breakfast_meal_Frag1 newInstance(int sectionNumber) {
        My_Breakfast_meal_Frag1 fragment = new My_Breakfast_meal_Frag1();
        return fragment;
    }
    //CONSTRUCTOR METHOD for frag
    public My_Breakfast_meal_Frag1() {
    }

    // Declare Buttons and text views.....
    Button buttonProteinB,buttonCarbohydrateB,buttonVegetablesB;
    TextView mealText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        //CHANGE THE LAYOUT FOR EACH OF THE MEALS DOWN HERE
        View rootView = inflater.inflate(R.layout.my_breakfast_meal_frag1, container, false);

        //ADD THE BUTTONS AND TEXTVIEW ETC.. Make ^^^this frag Layout^^^ implements the buttons.
        buttonProteinB = (Button) rootView.findViewById(R.id.buttonProteinB);
        buttonCarbohydrateB = (Button) rootView.findViewById(R.id.buttonCarbohydratesB);
        buttonVegetablesB = (Button) rootView.findViewById(R.id.buttonVegetablesB);
        mealText = (TextView) rootView.findViewById(R.id.textView);

        //Set listeners buttons
        buttonProteinB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO STUFF WHEN BUTTON IS CLICKED
                mealText.setText("Protein!!");
            }
        });
        //Set listeners buttons
        buttonCarbohydrateB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO STUFF WHEN BUTTON IS CLICKED
                mealText.setText("Carbohydrate!!");
            }
        });
        //Set listeners buttons
        buttonVegetablesB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO STUFF WHEN BUTTON IS CLICKED
                mealText.setText("Vegetables!!");
            }
        });
        return rootView;
    }
}
