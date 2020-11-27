package com.example.places;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Vector;

/*********************************************
 Copyright 2020 
 Author: Selik Samai
 Email: selik.samai@asu.edu
 Application: 
 Github: https://github.com/antonvinod/
 @Version 1 October 18th 2020
 *********************************************/

public class PlaceDescription {

    private String name, description, street, city, state, zip, category, title;
    private double elevation;
    private double latitude;
    private double longitude;

    public Vector<String> places;

    public PlaceDescription()
    {
        name = description = street = city = state = zip = category = title = null;
    }

    public PlaceDescription(PlaceDescription place)
    {
        this.name = place.name;
        this.description = place.description;
        this.street = place.street;
        this.city = place.street;;
        this.zip = place.zip;
        this.state = place.state;
        this.category = place.category;
        this.title = place.title;
    }

    public PlaceDescription(String jsonStr)
    {
        try
        {
            JSONObject jObj = new JSONObject(jsonStr);
            name = jObj.getString("name");
            description = jObj.getString("description");
            ////////////////////////
            street = jObj.getString("address-street");
            city = jObj.getString("city");
            zip = jObj.getString("zip");
            state = jObj.getString("state");
            ////////////////////////
            category = jObj.getString("category");
            title = jObj.getString("address-title");
            elevation = jObj.getDouble("elevation");
            latitude = jObj.getDouble("latitude");
            longitude = jObj.getDouble("longitude");

            places = new Vector<String>();
            JSONArray jArray = jObj.getJSONArray("places");
            for(int i = 0; i < jArray.length(); i++)
            {
                places.add(jArray.getString(i));
            }
        }
        catch (Exception e)
        {
            Log.d(this.getClass().getSimpleName(), "error converting string to/from JSON");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Vector<String> getPlaceDEsc() {
        return places;
    }

    public void setPlaceDEsc(Vector<String> placeDEsc) {
        this.places = placeDEsc;
    }

}
