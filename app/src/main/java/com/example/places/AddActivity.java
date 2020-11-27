package com.example.places;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/*********************************************
 Copyright 2020
 Author: Selik Samai
 Email: selik.samai@asu.edu
 Application: Places Application
 Github: https://github.com/antonvinod/
 @Version 1 October 18th 2020
 *********************************************/

public class AddActivity extends AppCompatActivity {

    public PlaceDescription place = new PlaceDescription();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(myToolbar);

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
            place.setName(nameTxt.getText().toString());
            place.setDescription(descriptionTxt.getText().toString());
            place.setStreet(streetTxt.getText().toString());
            place.setCity(cityTxt.getText().toString());
            place.setState(stateTxt.getText().toString());
            place.setZip(zipTxt.getText().toString());

        }

        return isValid;
    }
    public void saveButton(View view)
    {
        if(verifyInput())
        {
            PlaceLibrary lib = PlaceLibrary.getInstance();

            PlaceDescription place = new PlaceDescription();
            lib.addPlace(place);
        }
    }

    public void clearButton(View view)
    {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(this.getClass().getSimpleName(), "Called onOptionsItemSelected");

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        Intent intent;
        switch (item.getItemId())
        {
            case R.id.action_home:
                intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_add:
                //
                intent = new Intent(AddActivity.this, AddActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_modify:
                //
                intent = new Intent(AddActivity.this, ModifyActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_remove:
                //
                intent = new Intent(AddActivity.this, RemoveActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_distance:
                //

                return true;

            case R.id.action_initial:
                //
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}