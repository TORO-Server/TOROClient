package marumasa.toro_client.client;

import marumasa.toro_client.CreativeTab;
import marumasa.toro_client.TOROClient;
import marumasa.toro_client.util.Config;
import marumasa.toro_client.util.Utils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class TOROClientClient implements ClientModInitializer {

    public static final Config config = new Config();

    @Override
    public void onInitializeClient() {

        // クリエイティブタブのID を 設定
        Identifier tab_id = new Identifier(TOROClient.MOD_ID, "toro_client_group");

        // クリエイティブタブ登録
        Registry.register(Registries.ITEM_GROUP, tab_id, CreativeTab.Group);

        // configファイル読み込み
        config.load();


        // キーバインド登録
        KeyBinding jp_toggle = KeyBindingHelper.registerKeyBinding(Utils.createKeyBinding(
                "luna_chat.jp_toggle", GLFW.GLFW_KEY_J)
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            final ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
            if (networkHandler == null) return;
            final ServerInfo serverInfo = networkHandler.getServerInfo();
            if (serverInfo == null) return;
            final String address = serverInfo.address;

            // もしキーが押されたら
            while (jp_toggle.wasPressed()) {
                Boolean isJP = config.LunaChat_jp.get(address);

                if (isJP == null) isJP = true;
                final String arg = isJP ? "off" : "on";

                // コマンド送信
                networkHandler.sendCommand("jp " + arg);
                // config 設定
                config.LunaChat_jp.put(address, !isJP);
                config.save();
            }
        });
    }
}
