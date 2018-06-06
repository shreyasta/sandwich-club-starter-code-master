package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


/*Submitted by Shreyasta Samal */
public class JsonUtils {
    // continue adding the variables from  Sandwich.java



    public static Sandwich parseSandwichJson(String json) {
        // Initializing JSON Objects
        // Adding try and catch exception block
        try {
            // Initializing JSONObject from JSON Strings
            JSONObject sandwichNames = new JSONObject(json);
            JSONObject name = sandwichNames.getJSONObject("name");
            //get names and values
            String mainName = name.getString("mainName");
            String placeOfOrigin = sandwichNames.getString("placeOfOrigin");
            String description = sandwichNames.getString("description");
            String imagelocation = sandwichNames.getString("image");


            // Getting the arrayList  from the key called alsoKnownAs
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> akaList = new ArrayList<>();
            // for each item in the list, adding the items in the arraylist
            for (int i = 0; i < alsoKnownAs.length(); i++ ){
                akaList.add(alsoKnownAs.getString(i));
            }



            JSONArray ingredients = sandwichNames.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            // for each item in the list, adding the items in the arraylist
            for (int i = 0; i < ingredients.length(); i++ ){
                ingredientsList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName, akaList, placeOfOrigin, description, imagelocation, ingredientsList );

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return null;
    }
}
