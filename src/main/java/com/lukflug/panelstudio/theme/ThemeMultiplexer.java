//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.theme;

public abstract class ThemeMultiplexer implements Theme
{
    protected final Renderer panelRenderer;
    protected final Renderer containerRenderer;
    protected final Renderer componentRenderer;
    
    public ThemeMultiplexer() {
        this.panelRenderer = (Renderer)new PanelRenderer();
        this.containerRenderer = (Renderer)new ContainerRenderer();
        this.componentRenderer = (Renderer)new ComponentRenderer();
    }
    
    public Renderer getPanelRenderer() {
        return this.panelRenderer;
    }
    
    public Renderer getContainerRenderer() {
        return this.containerRenderer;
    }
    
    public Renderer getComponentRenderer() {
        return this.componentRenderer;
    }
    
    protected abstract Theme getTheme();
    
    protected class PanelRenderer extends RendererProxy
    {
        protected Renderer getRenderer() {
            return ThemeMultiplexer.this.getTheme().getPanelRenderer();
        }
    }
    
    protected class ContainerRenderer extends RendererProxy
    {
        protected Renderer getRenderer() {
            return ThemeMultiplexer.this.getTheme().getContainerRenderer();
        }
    }
    
    protected class ComponentRenderer extends RendererProxy
    {
        protected Renderer getRenderer() {
            return ThemeMultiplexer.this.getTheme().getComponentRenderer();
        }
    }
}
