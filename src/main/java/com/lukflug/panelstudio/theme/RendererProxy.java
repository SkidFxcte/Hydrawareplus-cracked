//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public abstract class RendererProxy implements Renderer
{
    public int getHeight(final boolean open) {
        return this.getRenderer().getHeight(open);
    }
    
    public int getOffset() {
        return this.getRenderer().getOffset();
    }
    
    public int getBorder() {
        return this.getRenderer().getBorder();
    }
    
    public int getBottomBorder() {
        return this.getRenderer().getBottomBorder();
    }
    
    public int getLeftBorder(final boolean scroll) {
        return this.getRenderer().getLeftBorder(scroll);
    }
    
    public int getRightBorder(final boolean scroll) {
        return this.getRenderer().getRightBorder(scroll);
    }
    
    public void renderTitle(final Context context, final String text, final boolean focus) {
        this.getRenderer().renderTitle(context, text, focus);
    }
    
    public void renderTitle(final Context context, final String text, final boolean focus, final boolean active) {
        this.getRenderer().renderTitle(context, text, focus, active);
    }
    
    public void renderTitle(final Context context, final String text, final boolean focus, final boolean active, final boolean open) {
        this.getRenderer().renderTitle(context, text, focus, active, open);
    }
    
    public void renderRect(final Context context, final String text, final boolean focus, final boolean active, final Rectangle rectangle, final boolean overlay) {
        this.getRenderer().renderRect(context, text, focus, active, rectangle, overlay);
    }
    
    public void renderBackground(final Context context, final boolean focus) {
        this.getRenderer().renderBackground(context, focus);
    }
    
    public void renderBorder(final Context context, final boolean focus, final boolean active, final boolean open) {
        this.getRenderer().renderBorder(context, focus, active, open);
    }
    
    public int renderScrollBar(final Context context, final boolean focus, final boolean active, final boolean scroll, final int childHeight, final int scrollPosition) {
        return this.getRenderer().renderScrollBar(context, focus, active, scroll, childHeight, scrollPosition);
    }
    
    public Color getMainColor(final boolean focus, final boolean active) {
        return this.getRenderer().getMainColor(focus, active);
    }
    
    public Color getBackgroundColor(final boolean focus) {
        return this.getRenderer().getBackgroundColor(focus);
    }
    
    public Color getFontColor(final boolean focus) {
        return this.getRenderer().getFontColor(focus);
    }
    
    public ColorScheme getDefaultColorScheme() {
        return this.getRenderer().getDefaultColorScheme();
    }
    
    public void overrideColorScheme(final ColorScheme scheme) {
        this.getRenderer().overrideColorScheme(scheme);
    }
    
    public void restoreColorScheme() {
        this.getRenderer().restoreColorScheme();
    }
    
    protected abstract Renderer getRenderer();
}
