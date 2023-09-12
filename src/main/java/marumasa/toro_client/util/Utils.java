package marumasa.toro_client.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import marumasa.toro_client.TOROClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Utils {

    private static final Gson gson = new Gson();


    public static ItemStack setNBT(Item item, String stringNBT) {

        // アイテム作成
        final ItemStack itemStack = new ItemStack(item);

        // NBTタグを設定する処理
        try {
            // String から NBTに変換
            final NbtCompound nbtTag = NbtHelper.fromNbtProviderString(stringNBT);
            // NBTタグ 設定
            itemStack.setNbt(nbtTag);
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }

        // NBTタグを設定したアイテムを返す
        return itemStack;
    }

    public static String getClientPlayerName() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return "";
        return player.getName().getString();
    }

    public static JsonObject loadJSON(Path path) {
        try (final BufferedReader reader = Files.newBufferedReader(path)) {
            return gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveJSON(Path path, JsonObject jsonObject) {
        try (final BufferedWriter writer = Files.newBufferedWriter(path)) {
            gson.toJson(jsonObject, JsonObject.class, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonObject toJsonObj(Map<String, Boolean> map) {
        JsonObject jsonObj = new JsonObject();
        for (String key : map.keySet()) {
            jsonObj.addProperty(key, map.get(key));
        }
        return jsonObj;
    }

    // キーバインド 作成
    public static KeyBinding createKeyBinding(String name, int code) {
        return new KeyBinding(
                // ID作成
                "key." + TOROClient.MOD_ID + "." + name,

                // どのキーか設定
                InputUtil.Type.KEYSYM, code,

                // カテゴリ設定
                "key.categories." + TOROClient.MOD_ID
        );
    }
}
