package club.auth.hydraware.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.google.common.base.*;
import club.auth.hydraware.manager.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Minecraft.class })
public class MixinMinecraft
{
    @Inject(method = { "shutdown" }, at = { @At("HEAD") })
    public void onShutdown(final CallbackInfo ci) {
        final Stopwatch watch = Stopwatch.createStarted();
        ConfigManager.save();
        System.out.printf("hydraware save config took %sms", watch.stop());
    }
}
