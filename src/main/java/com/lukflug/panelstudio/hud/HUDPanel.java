//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.hud;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.*;
import com.lukflug.panelstudio.theme.*;
import java.awt.*;

public class HUDPanel extends DraggableContainer
{
    protected Toggleable guiOpen;
    protected FixedComponent component;
    
    public HUDPanel(final FixedComponent component, final Renderer renderer, final Toggleable open, final Animation animation, final Toggleable guiOpen, final int minBorder) {
        super(component.getTitle(), (String)null, (Renderer)new HUDRenderer(renderer, guiOpen, minBorder), open, animation, (Toggleable)null, new Point(0, 0), 0);
        this.addComponent((Component)component);
        this.guiOpen = guiOpen;
        this.component = component;
        this.bodyDrag = true;
    }
    
    public void handleButton(final Context context, final int button) {
        if (this.guiOpen.isOn()) {
            super.handleButton(context, button);
        }
    }
    
    public void handleScroll(final Context context, final int diff) {
        if (this.guiOpen.isOn()) {
            super.handleScroll(context, diff);
        }
    }
    
    public Point getPosition(final Interface inter) {
        (this.position = this.component.getPosition(inter)).translate(0, -this.renderer.getHeight(this.open.getValue() != 0.0) - this.renderer.getOffset());
        return super.getPosition(inter);
    }
    
    public void setPosition(final Interface inter, final Point position) {
        this.component.setPosition(inter, new Point(position.x, position.y + this.renderer.getHeight(this.open.getValue() != 0.0) + this.renderer.getOffset()));
    }
    
    public int getWidth(final Interface inter) {
        return this.component.getWidth(inter) + this.renderer.getBorder() * 2 + this.renderer.getLeftBorder(this.scroll) + this.renderer.getRightBorder(this.scroll);
    }
    
    protected Rectangle getClipRect(final Context context, final int height) {
        if (this.open.getValue() != 1.0) {
            return super.getClipRect(context, height);
        }
        return null;
    }
    
    public void saveConfig(final Interface inter, final PanelConfig config) {
        this.component.saveConfig(inter, config);
        config.saveState(this.open.isOn());
    }
    
    public void loadConfig(final Interface inter, final PanelConfig config) {
        this.component.loadConfig(inter, config);
        if (this.open.isOn() != config.loadState()) {
            this.open.toggle();
        }
    }
    
    protected static class HUDRenderer extends RendererProxy
    {
        Renderer renderer;
        protected Toggleable guiOpen;
        protected int minBorder;
        
        public HUDRenderer(final Renderer renderer, final Toggleable guiOpen, final int minBorder) {
            this.renderer = renderer;
            this.guiOpen = guiOpen;
            this.minBorder = minBorder;
        }
        
        @Override
        public int getOffset() {
            return Math.max(this.renderer.getOffset(), this.minBorder);
        }
        
        @Override
        public int getBorder() {
            return Math.max(this.renderer.getBorder(), this.minBorder);
        }
        
        @Override
        public void renderTitle(final Context context, final String text, final boolean focus) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderTitle(context, text, focus);
            }
        }
        
        @Override
        public void renderTitle(final Context context, final String text, final boolean focus, final boolean active) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderTitle(context, text, focus, active);
            }
        }
        
        @Override
        public void renderTitle(final Context context, final String text, final boolean focus, final boolean active, final boolean open) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderTitle(context, text, focus, open);
            }
        }
        
        @Override
        public void renderRect(final Context context, final String text, final boolean focus, final boolean active, final Rectangle rectangle, final boolean overlay) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderRect(context, text, focus, active, rectangle, overlay);
            }
        }
        
        @Override
        public void renderBackground(final Context context, final boolean focus) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderBackground(context, focus);
            }
        }
        
        @Override
        public void renderBorder(final Context context, final boolean focus, final boolean active, final boolean open) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderBorder(context, focus, active, open);
            }
        }
        
        @Override
        public int renderScrollBar(final Context context, final boolean focus, final boolean active, final boolean scroll, final int childHeight, final int scrollPosition) {
            if (this.guiOpen.isOn()) {
                return this.renderer.renderScrollBar(context, focus, active, scroll, childHeight, scrollPosition);
            }
            return scrollPosition;
        }
        
        @Override
        public Color getMainColor(final boolean focus, final boolean active) {
            if (this.guiOpen.isOn()) {
                return this.renderer.getMainColor(focus, active);
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public Color getBackgroundColor(final boolean focus) {
            if (this.guiOpen.isOn()) {
                return this.renderer.getBackgroundColor(focus);
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public Color getFontColor(final boolean focus) {
            if (this.guiOpen.isOn()) {
                return this.renderer.getFontColor(focus);
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        protected Renderer getRenderer() {
            return this.renderer;
        }
    }
}
