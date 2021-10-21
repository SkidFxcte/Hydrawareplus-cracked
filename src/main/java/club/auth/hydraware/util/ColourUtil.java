package club.auth.hydraware.util;

import java.awt.*;

public class ColourUtil implements Global
{
    public static int shadeColour(final int color, final int precent) {
        final int r = ((color & 0xFF0000) >> 16) * (100 + precent) / 100;
        final int g = ((color & 0xFF00) >> 8) * (100 + precent) / 100;
        final int b = (color & 0xFF) * (100 + precent) / 100;
        return new Color(r, g, b).hashCode();
    }
    
    public static Color getColour() {
        return (Color)Colour.fromHSB(System.currentTimeMillis() % 11520L / 11520.0f, 1.0f, 1.0f);
    }
    
    public static Color getFurtherColour(final int offset) {
        return (Color)Colour.fromHSB((System.currentTimeMillis() + offset) % 11520L / 11520.0f, 1.0f, 1.0f);
    }
}
