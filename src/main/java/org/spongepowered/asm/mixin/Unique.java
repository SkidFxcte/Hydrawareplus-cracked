//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package org.spongepowered.asm.mixin;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    boolean silent() default false;
}
