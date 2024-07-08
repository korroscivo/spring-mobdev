package com.mobdev.backend.repository;

import com.mobdev.backend.model.Breed;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

@Repository
public class BreedRepository {
    public JSONObject getJsonByURL(String urlString ) throws IOException, JSONException {
        URL url = new URL(urlString);
        String json = IOUtils.toString(url, Charset.forName("UTF-8"));
        JSONObject jsonObj  = new JSONObject(json);
        return jsonObj;
    }
}
