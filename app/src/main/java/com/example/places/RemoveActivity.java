package com.example.places;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

/*********************************************
 Copyright 2020
 Author: Selik Samai
 Email: selik.samai@asu.edu
 Application: Places Application
 Github: https://github.com/antonvinod/
 @Version 1 October 18th 2020
 *********************************************/

public class RemoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

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
                intent = new Intent(RemoveActivity.this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_add:
                //
                intent = new Intent(RemoveActivity.this, AddActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_modify:
                //
                intent = new Intent(RemoveActivity.this, ModifyActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_remove:
                //
                intent = new Intent(RemoveActivity.this, RemoveActivity.class);
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