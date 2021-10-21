//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware;

import club.minnced.discord.rpc.*;

public class RPC
{
    private static final DiscordRichPresence discordRichPresence;
    private static final DiscordRPC discordRPC;
    
    public static void startRPC() {
        final DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        eventHandlers.disconnected = ((var1, var2) -> System.out.println("Discord RPC disconnected, var1: " + var1 + ", var2: " + var2));
        final String discordID = "861479735351574568";
        RPC.discordRPC.Discord_Initialize(discordID, eventHandlers, true, null);
        RPC.discordRichPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        RPC.discordRichPresence.details = "++";
        RPC.discordRichPresence.largeImageKey = "revenge";
        RPC.discordRichPresence.largeImageText = "HydraWare-Beta-Dev";
        RPC.discordRichPresence.smallImageKey = "small";
        RPC.discordRichPresence.smallImageText = "EZ KILLING NIGGAS";
        RPC.discordRichPresence.state = null;
        RPC.discordRPC.Discord_UpdatePresence(RPC.discordRichPresence);
    }
    
    public static void stopRPC() {
        RPC.discordRPC.Discord_Shutdown();
        RPC.discordRPC.Discord_ClearPresence();
    }
    
    static {
        discordRichPresence = new DiscordRichPresence();
        discordRPC = DiscordRPC.INSTANCE;
    }
}
