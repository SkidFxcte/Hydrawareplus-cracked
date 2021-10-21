package org.spongepowered.asm.mixin.gen;

import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.lib.*;

public abstract class AccessorGeneratorField extends AccessorGenerator
{
    protected final FieldNode targetField;
    protected final Type targetType;
    protected final boolean isInstanceField;
    
    public AccessorGeneratorField(final AccessorInfo info) {
        super(info);
        this.targetField = info.getTargetField();
        this.targetType = info.getTargetFieldType();
        this.isInstanceField = ((this.targetField.access & 0x8) == 0x0);
    }
}
