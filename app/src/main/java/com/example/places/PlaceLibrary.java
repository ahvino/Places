package com.example.places;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/*********************************************
 Copyright 2020 
 Author: Selik Samai
 Email: selik.samai@asu.edu
 Application: Places Application
 Github: https://github.com/antonvinod/
 @Version 1 October 18th 2020
 *********************************************/
public class PlaceLibrary {

    private HashMap<String, PlaceDescription> m_placeLib;

    private static ArrayList<PlaceDescription> placeArray;
    private PlaceDescription m_place;
    private static PlaceLibrary library = null;


    /**
     * Returns a singleton instance of the place library. This is the only one
     * that exists. If the singleton does not exist, then one will be created via the constructor.
     * @return
     */
    public static PlaceLibrary getInstance()
    {
        if(library == null)
        {
            library = new PlaceLibrary();
            placeArray = new ArrayList<PlaceDescription>();
        }
        return library;
    }

    public PlaceLibrary()
    {
        m_placeLib = new HashMap<String, PlaceDescription>();
        placeArray = new ArrayList<PlaceDescription>();
    }

    public static ArrayList<PlaceDescription> getPlaceArray() {
        return placeArray;
    }

    public static void setPlaceArray(ArrayList<PlaceDescription> placeArray) {
        PlaceLibrary.placeArray = placeArray;
    }

    /**
     * Will add a place to the library of place descriptions.
     * If the name/place already exists, will not add a duplicate
     * and should try to alert the user of such or at least log.
     * @param place
     */
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

    /**
     * Will return a place description object if the place name exists.
     * Probably should return an alert dialog if no name exists.
     * Also should be ignoring case too.
     * @param placeName
     * @return
     */
    public PlaceDescription getPlace(String placeName)
    {
        PlaceDescription place = new PlaceDescription();

        //get the place from the hashmap assuming it's not null
        if(m_placeLib.get(placeName) != null)
        {
            place = m_placeLib.get(placeName);
        }
        else
        {
            Log.d(this.getClass().getSimpleName(), "Place " + placeName+ " is not in the library.");
        }
        return place;
    }
}
