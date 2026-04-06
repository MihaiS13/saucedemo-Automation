package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static JSONObject json(String name) {
        // Use File.separator to handle paths correctly on both Windows (\) and Linux (/)
        String jsonPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "java" + File.separator + "testData" + File.separator + "files"
                + File.separator + name + ".json";

        JSONObject obj = null;


        try (FileReader reader = new FileReader(jsonPath)) {
            JSONParser jsonParser = new JSONParser();
            obj = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            System.err.println("Error reading the JSON file: " + jsonPath);
            e.printStackTrace();
        }

        return obj;
    }
}

