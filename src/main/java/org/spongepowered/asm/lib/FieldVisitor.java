package org.spongepowered.asm.lib;

public abstract class FieldVisitor
{
    protected final int api;
    protected FieldVisitor fv;
    
    public FieldVisitor(final int api) {
        this(api, null);
    }
    
    public FieldVisitor(final int api, final FieldVisitor fv) {
        if (api != 262144 && api != 327680) {
            throw new IllegalArgumentException();
        }
        this.api = api;
        this.fv = fv;
    }
    
    public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
        if (this.fv != null) {
            return this.fv.visitAnnotation(desc, visible);
        }
        return null;
    }
    
    public AnnotationVisitor visitTypeAnnotation(final int typeRef, final TypePath typePath, final String desc, final boolean visible) {
        if (this.api < 327680) {
            throw new Class18();
        }
        if (this.fv != null) {
            return this.fv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }
        return null;
    }
    
    public void visitAttribute(final Attribute attr) {
        if (this.fv != null) {
            this.fv.visitAttribute(attr);
        }
    }
    
    public void visitEnd() {
        if (this.fv != null) {
            this.fv.visitEnd();
        }
    }
}
