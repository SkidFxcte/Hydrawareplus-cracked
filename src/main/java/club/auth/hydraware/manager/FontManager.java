package club.auth.hydraware.manager;

import club.auth.hydraware.util.*;
import net.minecraft.client.*;
import java.awt.*;

public class FontManager
{
    private final CFontRenderer cFontRenderer;
    private final Minecraft mc;
    private boolean customFont;
    
    public FontManager() {
        this.cFontRenderer = new CFontRenderer(new Font("Forte", 0, 18), true, true);
        this.mc = Minecraft.getMinecraft();
        this.customFont = true;
    }
    
    public void setCustomFont(final boolean customFont) {
        this.customFont = customFont;
    }
    
    public void drawStringWithShadow(final String text, final float x, final float y, final int color) {
        if (this.customFont) {
            this.cFontRenderer.drawStringWithShadow(text, x, y, color);
            return;
        }
        this.mc.fontRenderer.drawStringWithShadow(text, x, y, color);
    }
    
    public int getStringWidth(final String text) {
        if (this.customFont) {
            return this.cFontRenderer.getStringWidth(text);
        }
        return this.mc.fontRenderer.getStringWidth(text);
    }
}
