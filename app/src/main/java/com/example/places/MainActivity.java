package com.example.places;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/*********************************************
 Copyright 2020
 Author: Selik Samai
 Email: selik.samai@asu.edu
 Application: Places Application
 Github: https://github.com/antonvinod/
 @Version 1 October 18th 2020
 *********************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(myToolbar);

        //setSpinner();

    }

    public void setSpinner()
    {
        Spinner spinner = (Spinner) findViewById(R.id.place_spinner);

        ArrayList<PlaceDescription> places = PlaceLibrary.getPlaceArray();

        ArrayList<String> arrayList = new ArrayList<>();

        for(int i = 0; i < places.size(); i++)
        {
            arrayList.add(places.get(i).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String placeName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + placeName, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public void startDialog(View view){
        Log.d(this.getClass().getSimpleName(), "called startDialog");
        Intent intent = new Intent(MainActivity.this, AlertActivity.class);
        startActivity(intent);
    }

    public void addButton(View view){
        Log.d(this.getClass().getSimpleName(), "called add activity");
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }

    public void modifyButton(View view){
        Log.d(this.getClass().getSimpleName(), "called add activity");
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }

    public void removeButton(View view){
        Log.d(this.getClass().getSimpleName(), "called add activity");
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }

    public void distanceButton(View view){
        Log.d(this.getClass().getSimpleName(), "called add activity");
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }

    public void bearingButton(View view){
        Log.d(this.getClass().getSimpleName(), "called add activity");
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
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
                intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_add:
                //
                intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_modify:
                //
                intent = new Intent(MainActivity.this, ModifyActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_remove:
                //
                intent = new Intent(MainActivity.this, RemoveActivity.class);
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