package com.example.admin.materialdesigndemo.retrofit;

import com.example.admin.materialdesigndemo.retrofit.bean.LoginResultEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by master on 2017/3/30 0030.
 */

public class GsonEngine {
    public static Gson defaultGson;

    public static Gson getDefaultGson() {
        if (defaultGson == null) {
            defaultGson = new Gson();
        }
        return defaultGson;
    }

    public static Gson responseGson;

    public static Gson getResponseGson() {
        if (responseGson == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(LoginResultEntity.class, new LoginBodyJsonDeserializer());
            responseGson = builder.create();
        }
        return responseGson;
    }

    static class LoginBodyJsonDeserializer implements JsonDeserializer<LoginResultEntity> {

        @Override
        public LoginResultEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json.isJsonObject()) {
                return getDefaultGson().fromJson(json, typeOfT);
            }
            return null;
        }
    }
}
