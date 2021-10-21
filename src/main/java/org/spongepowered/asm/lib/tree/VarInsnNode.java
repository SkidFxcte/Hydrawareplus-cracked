package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;
import java.util.*;

public class VarInsnNode extends AbstractInsnNode
{
    public int fd_int_2;
    
    public VarInsnNode(final int opcode, final int var) {
        super(opcode);
        this.fd_int_2 = var;
    }
    
    public void setOpcode(final int opcode) {
        this.opcode = opcode;
    }
    
    public int getType() {
        return 2;
    }
    
    public void accept(final MethodVisitor mv) {
        mv.visitVarInsn(this.opcode, this.fd_int_2);
        this.acceptAnnotations(mv);
    }
    
    public AbstractInsnNode clone(final Map<LabelNode, LabelNode> labels) {
        return new VarInsnNode(this.opcode, this.fd_int_2).cloneAnnotations((AbstractInsnNode)this);
    }
}
