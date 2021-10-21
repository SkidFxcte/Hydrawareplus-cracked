//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public abstract class RendererBase implements Renderer
{
    protected final int height;
    protected final int offset;
    protected final int border;
    protected final int left;
    protected final int right;
    protected ColorScheme scheme;
    
    public RendererBase(final int height, final int offset, final int border, final int left, final int right) {
        this.scheme = null;
        this.height = height;
        this.offset = offset;
        this.border = border;
        this.left = left;
        this.right = right;
    }
    
    public int getHeight(final boolean open) {
        return this.height;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getBorder() {
        return this.border;
    }
    
    public int getBottomBorder() {
        return 0;
    }
    
    public int getLeftBorder(final boolean scroll) {
        if (scroll) {
            return this.left;
        }
        return 0;
    }
    
    public int getRightBorder(final boolean scroll) {
        if (scroll) {
            return this.right;
        }
        return 0;
    }
    
    public void renderTitle(final Context context, final String text, final boolean focus) {
        this.renderTitle(context, text, focus, false);
    }
    
    public void renderTitle(final Context context, final String text, final boolean focus, final boolean active) {
        this.renderRect(context, text, focus, active, context.getRect(), true);
    }
    
    public void renderTitle(final Context context, final String text, final boolean focus, final boolean active, final boolean open) {
        this.renderTitle(context, text, focus, active);
    }
    
    public int renderScrollBar(final Context context, final boolean focus, final boolean active, final boolean scroll, final int childHeight, final int scrollPosition) {
        return scrollPosition;
    }
    
    public Color getFontColor(final boolean focus) {
        return this.getColorScheme().getFontColor();
    }
    
    public void overrideColorScheme(final ColorScheme scheme) {
        this.scheme = scheme;
    }
    
    public void restoreColorScheme() {
        this.scheme = null;
    }
    
    protected ColorScheme getColorScheme() {
        if (this.scheme == null) {
            return this.getDefaultColorScheme();
        }
        return this.scheme;
    }
}
