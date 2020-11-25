package com.example.places;

import android.util.Log;

import java.util.HashMap;

/*********************************************
 Copyright 2020 
 Author: Selik Samai
 Email: selik.samai@asu.edu
 Application: 
 Github: https://github.com/antonvinod/
 @Version 1 October 18th 2020
 *********************************************/
public class PlaceLibrary {

    private HashMap<String, PlaceDescription> m_placeLib;
    private PlaceDescription m_place;

    public PlaceLibrary()
    {
        m_placeLib = new HashMap<String, PlaceDescription>();
    }

    public void addPlace(PlaceDescription place)
    {
        String placeName = place.getName();

        if(m_placeLib.containsKey(placeName))
        {
            Log.d(this.getClass().getSimpleName(), "Place " + place.getName() + " has already been added.");
        }
        else {
            m_placeLib.put(place.getName(), place);
        }
    }

    public PlaceDescription getPlace(String placeName)
    {
        PlaceDescription place = new PlaceDescription();

        //get the place from the hashmap assuming it's not null
        if(m_placeLib.get(placeName) != null)
        {
            place = m_placeLib.get(placeName);
        }
        return place;
    }
}
