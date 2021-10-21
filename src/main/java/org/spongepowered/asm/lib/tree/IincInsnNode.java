//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;
import java.util.*;

public class IincInsnNode extends AbstractInsnNode
{
    public int fd_int_1;
    public int incr;
    
    public IincInsnNode(final int var, final int incr) {
        super(132);
        this.fd_int_1 = var;
        this.incr = incr;
    }
    
    public int getType() {
        return 10;
    }
    
    public void accept(final MethodVisitor mv) {
        mv.visitIincInsn(this.fd_int_1, this.incr);
        this.acceptAnnotations(mv);
    }
    
    public AbstractInsnNode clone(final Map<LabelNode, LabelNode> labels) {
        return new IincInsnNode(this.fd_int_1, this.incr).cloneAnnotations((AbstractInsnNode)this);
    }
}
