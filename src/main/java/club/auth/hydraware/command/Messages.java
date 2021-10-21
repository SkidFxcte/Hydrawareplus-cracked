

package club.auth.hydraware.command;

import net.minecraft.client.*;
import net.minecraft.util.text.*;
import com.mojang.realmsclient.gui.*;

public class Messages
{
    public static void sendPlayerMessage(final String... message) {
        for (final String m : message) {
            Minecraft.getMinecraft().player.sendChatMessage(m);
        }
    }
    
    public static void sendSilentMessage(final String... message) {
        for (final String m : message) {
            Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(m));
        }
    }
    
    public static void sendClientMessage(final String... message) {
        for (final String m : message) {
            final String prefix = ChatFormatting.DARK_RED + "(" + "HydraWare" + "+) " + ChatFormatting.RESET;
            Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(prefix + m));
        }
    }
}
