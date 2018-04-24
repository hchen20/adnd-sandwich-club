package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try {
            JSONObject sandwishJson = new JSONObject(json);
            JSONObject sandwichName = sandwishJson.getJSONObject("name");
            String mainName = sandwichName.getString("mainName");

            String orgin = sandwishJson.getString("placeOfOrigin");
            String description = sandwishJson.getString("description");

            sandwich.setMainName(mainName);
            sandwich.setPlaceOfOrigin(orgin);
            sandwich.setDescription(description);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
