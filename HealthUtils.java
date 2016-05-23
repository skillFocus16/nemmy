package namy.healthtrack;

import org.json.JSONObject;

/**
 * Created by BANGALORE on 5/13/2016.
 */
public class HealthUtils {

    public static boolean contains(JSONObject jsonObject, String key) {
        return jsonObject != null && jsonObject.has(key) && !jsonObject.isNull(key) ? true : false;
    }

}

