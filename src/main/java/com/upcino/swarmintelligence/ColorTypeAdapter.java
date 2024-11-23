package com.upcino.swarmintelligence;

import com.google.gson.*;
import java.awt.Color;
import java.lang.reflect.Type;

public class ColorTypeAdapter implements JsonSerializer<Color>, JsonDeserializer<Color> {
    @Override
    public JsonElement serialize(Color color, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty("rgb", color.getRGB());
        return json;
    }

    @Override
    public Color deserialize(JsonElement json, Type type, JsonDeserializationContext context) 
        throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        return new Color(jsonObject.get("rgb").getAsInt(), true);
    }
}