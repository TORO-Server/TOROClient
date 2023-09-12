package marumasa.toro_client.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import marumasa.toro_client.TOROClient;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private static final Path path = FabricLoader.getInstance().getConfigDir().normalize()
            .resolve(TOROClient.MOD_ID + ".json");

    public Map<String, Boolean> LunaChat_jp = new HashMap<>();

    public void deserialize() {
        final JsonObject jsonObject = Utils.loadJSON(path);

        LunaChat_jp = new Gson().fromJson(
                jsonObject.get("LunaChat_jp"),
                new TypeToken<Map<String, Boolean>>() {
                }.getType()
        );
    }

    public JsonObject serialize() {
        final JsonObject jsonObj = new JsonObject();
        final JsonObject serverJsonObj = Utils.toJsonObj(LunaChat_jp);

        jsonObj.add("LunaChat_jp", serverJsonObj);

        return jsonObj;
    }

    public void load() {
        final File configFile = path.toFile();
        if (!configFile.exists()) {
            save();
        } else {
            deserialize();
        }
    }

    public void save() {
        Utils.saveJSON(path, serialize());
    }
}
