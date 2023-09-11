package marumasa.toro_client;

import marumasa.toro_client.util.Utils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public class CreativeTab {
    // クリエイティブタブ
    public static ItemGroup Group = FabricItemGroup.builder().icon(
            // アイコン
            () -> new ItemStack(TOROClient.ToroIcon)
    ).displayName(
            // 表示する文字
            Text.translatable("itemGroup." + TOROClient.MOD_ID)
    ).entries((displayContext, entries) -> {


        // ここにクリエイティブに追加したいアイテムを書く
        entries.add(Utils.setNBT(
                Items.WOODEN_AXE,
                "{Unbreakable:1,AttributeModifiers:[{AttributeName:\"generic.attack_damage\",Amount:1024,Slot:mainhand,Name:\"generic.attack_damage\",UUID:[I;-123812,33190,12112,-66380]},{AttributeName:\"generic.attack_speed\",Amount:2,Slot:mainhand,Operation:2,Name:\"generic.attack_speed\",UUID:[I;-123812,33290,12112,-66580]}],display:{Lore:['[{\"text\":\"攻撃力1024の木の斧\",\"italic\":false,\"color\":\"gold\"}]']}}"
        ));
        entries.add(Utils.setNBT(
                Items.PLAYER_HEAD,
                String.format("{SkullOwner:%s,display:{Lore:['[{\"text\":\"自分の頭\",\"italic\":false,\"color\":\"gold\"}]']}}", Utils.getClientPlayerName())
        ));
        entries.add(Utils.setNBT(
                Items.CREEPER_SPAWN_EGG,
                "{EntityTag:{Fuse:0,ExplosionRadius:127},display:{Name:'[{\"text\":\"お掃除ボム\",\"italic\":false}]',Lore:['[{\"text\":\"爆発力127の即時爆発するクリーパーを召喚\",\"italic\":false,\"color\":\"gold\"}]']}}"
        ));
        entries.add(Utils.setNBT(
                Items.ITEM_FRAME,
                "{display:{Lore:['[{\"text\":\"透明な額縁\",\"italic\":false,\"color\":\"gold\"}]']},EntityTag:{Invisible:1b}}"
        ));
        entries.add(Utils.setNBT(
                Items.GLOW_ITEM_FRAME,
                "{display:{Lore:['[{\"text\":\"透明な額縁\",\"italic\":false,\"color\":\"gold\"}]']},EntityTag:{Invisible:1b}}"
        ));

        entries.add(Utils.setNBT(
                Items.DISPENSER,
                "{display:{Name:'[{\"text\":\"infinity\",\"italic\":false}]',Lore:['[{\"text\":\"「infinity」と名前を付けられた\",\"italic\":false,\"color\":\"gold\"},{\"text\":\"ディスペンサー\",\"color\":\"yellow\"},{\"text\":\"\",\"color\":\"dark_purple\"}]','[{\"text\":\"TOROサーバーでは、「infinity」と名前を付けると\",\"italic\":false,\"color\":\"gold\"}]','[{\"text\":\"中に入っているアイテムを消費しなくなります。\",\"italic\":false,\"color\":\"gold\"}]']}}"
        ));
        entries.add(Utils.setNBT(
                Items.DROPPER,
                "{display:{Name:'[{\"text\":\"infinity\",\"italic\":false}]',Lore:['[{\"text\":\"「infinity」と名前を付けられた\",\"italic\":false,\"color\":\"gold\"},{\"text\":\"ドロッパー\",\"color\":\"yellow\"},{\"text\":\"\",\"color\":\"dark_purple\"}]','[{\"text\":\"TOROサーバーでは、「infinity」と名前を付けると\",\"italic\":false,\"color\":\"gold\"}]','[{\"text\":\"中に入っているアイテムを消費しなくなります。\",\"italic\":false,\"color\":\"gold\"}]']}}"
        ));
        entries.add(Utils.setNBT(
                Items.SPLASH_POTION,
                "{CustomPotionColor:16777215,display:{Name:'[{\"text\":\"即死ポーション\",\"italic\":false}]',Lore:['[{\"text\":\"生物を即死させるポーション\",\"italic\":false,\"color\":\"gold\"},{\"text\":\"\",\"italic\":false,\"color\":\"dark_purple\"}]','[{\"text\":\"クリエイティブモードのプレイヤーには効果がありません\",\"italic\":false,\"color\":\"blue\"}]']},HideFlags:32,CustomPotionEffects:[{Id:7,Duration:0,Amplifier:28},{Id:6,Duration:0,Amplifier:28}]}"
        ));
        entries.add(Utils.setNBT(
                Items.SPLASH_POTION,
                "{CustomPotionColor:0,display:{Name:'[{\"text\":\"即死ポーション\",\"italic\":false}]',Lore:['[{\"text\":\"生物を即死させるポーション\",\"italic\":false,\"color\":\"gold\"},{\"text\":\"\",\"italic\":false,\"color\":\"dark_purple\"}]','[{\"text\":\"クリエイティブモードのプレイヤーにも効果があります\",\"italic\":false,\"color\":\"red\"}]']},HideFlags:32,CustomPotionEffects:[{Id:7,Duration:0,Amplifier:29},{Id:6,Duration:0,Amplifier:29}]}"
        ));

    }).build();
}
