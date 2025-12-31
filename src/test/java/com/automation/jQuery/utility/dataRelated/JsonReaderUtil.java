package com.automation.jQuery.utility.dataRelated;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class JsonReaderUtil {

    // -----Methods------//
// step 1:  open the json file and read its content
// step 2:  return the content as a string
    private String jsonToString(String filePath) {
        String stringform = null;
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader(filePath));
            JSONObject jsonObj = (JSONObject) object;
            stringform = (String) jsonObj.toJSONString();
            return stringform;
        } catch (Exception e) {
            e.printStackTrace();
            error("Error occured while reading data from Json with path " + filePath);
        }
        return stringform;
    }

    /**
     * Enter your jason path query to extract the user related data
     *
     * @param query
     * @return string
     */
    public String data(String filePath, String query) {
        String jsonStr = jsonToString(filePath);
        return JsonPath.read(jsonStr, query);
    }
}
