package marumasa.toro_client;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TOROClient implements ModInitializer {

    // ModのID
    public static final String MOD_ID = "toro_client";

    // クリエイティブタブに表示する用のアイテム
    public static final Item ToroIcon = new Item(new FabricItemSettings());

    @Override
    public void onInitialize() {
        // クリエイティブタブに表示する用のアイテム を登録
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "toro_icon"), ToroIcon);
    }
}
