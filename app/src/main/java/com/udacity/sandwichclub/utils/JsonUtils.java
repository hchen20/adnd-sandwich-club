package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sSandwich = new Sandwich();

        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject sandwichName = sandwich.getJSONObject("name");
            String mainName = sandwichName.getString("mainName");

            String origin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");
            JSONArray ingredients = sandwich.getJSONArray("ingredients");
            JSONArray alsoKnownAs = sandwichName.getJSONArray("alsoKnownAs");




            sSandwich.setMainName(mainName);
            sSandwich.setPlaceOfOrigin(origin);
            sSandwich.setDescription(description);
            sSandwich.setImage(image);
            sSandwich.setIngredients(getStringsFromJSON(ingredients));
            sSandwich.setAlsoKnownAs(getStringsFromJSON(alsoKnownAs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sSandwich;
    }

    private static List<String> getStringsFromJSON(JSONArray array) {
        List<String> list = new ArrayList<String>();

        int length = array.length();
        for (int i=0; i<length; i++) {
            list.add(array.optString(i));
        }

        return list;
    }
}
