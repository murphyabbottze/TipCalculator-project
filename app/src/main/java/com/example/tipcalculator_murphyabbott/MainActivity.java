package com.example.tipcalculator_murphyabbott;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity
{

    EditText subTotal;
    EditText numPeople;
    EditText gratOther;

    double gratAmount;
    double eachPersonPays;
    double total;

    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rbOther;

    Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subTotal = findViewById(R.id.editTextTotal);
        numPeople = findViewById(R.id.editTextPeople);
        gratOther = findViewById(R.id.editTextOther);

        total = (Double.parseDouble(subTotal.getText().toString())* Double.parseDouble(gratOther.getText().toString())) + Double.parseDouble(subTotal.getText().toString());
        eachPersonPays = (total/Double.parseDouble(numPeople.getText().toString()));

        calcButton = (Button) findViewById(R.id.calcButton);

        calcButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId())
        {
            case R.id.radioButton1:
                if (checked)
                    gratAmount = .15;
                break;
            case R.id.radioButton2:
                if (checked)
                    gratAmount = .2;
                break;
            case R.id.radioButton3:
                if (checked)
                    gratAmount = .25;
                break;
            case R.id.radioButton4:
                if (checked)
                    gratAmount = Double.parseDouble(gratOther.getText().toString());
                break;
        }
    }

//Optional
//    private View.OnKeyListener mKeyListener = new View.OnKeyListener()
//    {
//        @Override
//        public boolean onKey(View view, int keyCode, KeyEvent event)
//        {
//            switch(view.getId())
//            {
//                case R.id.editTextTotal:
//                    if(total != null)
//                    {
//
//
//
//            }
//        }
//    }
}