package com.example.places;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(this.getClass().getSimpleName(), "Called onStart");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(this.getClass().getSimpleName(), "Called onRestart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(this.getClass().getSimpleName(), "Called onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(this.getClass().getSimpleName(), "Called onPause");
    }

    @Override public void onStop(){
        super.onStop();
        Log.d(this.getClass().getSimpleName(), "Called onStop");
    }

    @Override public void onDestroy(){
        super.onDestroy();
        Log.d(this.getClass().getSimpleName(), "Called onDestory");
    }

    public boolean verifyInput()
    {
        boolean isValid = true;
        EditText nameTxt = (EditText) findViewById(R.id.add_name);
        EditText descriptionTxt = (EditText) findViewById(R.id.add_description);
        EditText streetTxt = (EditText) findViewById(R.id.add_street);
        EditText cityTxt = (EditText) findViewById(R.id.add_city);
        EditText stateTxt = (EditText) findViewById(R.id.add_state);
        EditText zipTxt = (EditText) findViewById(R.id.add_zip);


        if(nameTxt.getText().toString().isEmpty() ||
        descriptionTxt.getText().toString().isEmpty() ||
        streetTxt.getText().toString().isEmpty() ||
        cityTxt.getText().toString().isEmpty() ||
        stateTxt.getText().toString().isEmpty() ||
        zipTxt.getText().toString().isEmpty())
        {
            isValid = false;
        }
        else
        {
            PlaceDescription place = new PlaceDescription();
            place.setName(nameTxt.getText().toString());
            place.setDescription(descriptionTxt.getText().toString());
            place.setStreet(streetTxt.getText().toString());
            place.setCity(cityTxt.getText().toString());
            place.setState(stateTxt.getText().toString());
            place.setZip(zipTxt.getText().toString());

            PlaceLibrary lib = PlaceLibrary.getInstance();

            lib.addPlace(place);
        }


        return isValid;
    }
    public void saveButton(View view)
    {

    }

    public void clearButton(View view)
    {

    }

}