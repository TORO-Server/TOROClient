package marumasa.toro_client.util;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;

public class Utils {
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
}
