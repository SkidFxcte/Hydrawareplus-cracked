//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware;

import net.minecraftforge.fml.common.*;
import me.zero.alpine.*;
import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.*;
import club.auth.hydraware.gui.*;
import net.minecraftforge.common.*;
import club.auth.hydraware.event.*;
import com.google.common.base.*;
import club.auth.hydraware.manager.*;
import net.minecraftforge.fml.common.event.*;
import org.lwjgl.opengl.*;

@Mod(modid = "hydraware", name = "HydraWare", version = "++")
public class HydraWare
{
    public static final String MODID = "hydraware";
    public static final String NAME = "HydraWare";
    public static final String VERSION = "++";
    public static final String NAME_VERSION = "HydraWare++";
    @Mod.Instance
    public static HydraWare instance;
    public static final EventManager EVENT_BUS;
    public static ModuleManager moduleManager;
    public static SettingsManager settingsManager;
    public static FontManager fontManager;
    public static ServerManager serverManager;
    public static RotationManager rotationManager;
    public static PositionManager positionManager;
    public Screen clickGui;
    
    @Mod.EventHandler
    public void init(final FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register((Object)HydraWare.instance);
        HydraWare.settingsManager = new SettingsManager();
        HydraWare.moduleManager = new ModuleManager();
        HydraWare.fontManager = new FontManager();
        HydraWare.serverManager = new ServerManager();
        HydraWare.rotationManager = new RotationManager();
        HydraWare.positionManager = new PositionManager();
        new EventProcessor();
        this.clickGui = new Screen();
        final Stopwatch watch = Stopwatch.createStarted();
        ConfigManager.load();
        System.out.printf("AuthX Is God -Everyone", new Object[0]);
        System.out.printf("i made ISIS Cry. -AuthX", new Object[0]);
        System.out.printf("HydraWare load config took %sms", watch.stop());
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        Display.setTitle("HydraWare++ | <3");
    }
    
    static {
        HydraWare.instance = new HydraWare();
        EVENT_BUS = new EventManager();
    }
}
