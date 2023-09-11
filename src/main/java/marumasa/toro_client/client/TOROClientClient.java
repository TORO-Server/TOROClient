package marumasa.toro_client.client;

import marumasa.toro_client.CreativeTab;
import marumasa.toro_client.TOROClient;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TOROClientClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // クリエイティブタブのID を 設定
        Identifier tab_id = new Identifier(TOROClient.MOD_ID, "toro_client_group");

        // クリエイティブタブ登録
        Registry.register(Registries.ITEM_GROUP, tab_id, CreativeTab.Group);

    }
}
