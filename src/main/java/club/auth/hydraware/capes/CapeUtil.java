package club.auth.hydraware.capes;

import java.util.*;
import net.minecraft.util.*;
import java.net.*;
import java.io.*;
import club.auth.hydraware.util.*;
import javax.imageio.*;
import net.minecraft.client.renderer.texture.*;

public class CapeUtil
{
    public static ArrayList<String> lines;
    public static List<ResourceLocation> capeStuff;
    
    public static void getUsersCape() {
        try {
            final URL url = new URL("https://pastebin.com/raw/3f7St1Ur");
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                CapeUtil.lines.add(line);
            }
            bufferedReader.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static boolean isCapeUser(final String name) {
        return CapeUtil.lines.contains(name);
    }
    
    static {
        CapeUtil.capeStuff = new ArrayList<ResourceLocation>();
        try {
            CapeUtil.capeStuff.add(Wrapper.mc.getTextureManager().getDynamicTextureLocation("assets/textures", new DynamicTexture(ImageIO.read(new URL("https://imgur.com/a/W84LYTB")))));
            CapeUtil.capeStuff.add(Wrapper.mc.getTextureManager().getDynamicTextureLocation("assets/textures", new DynamicTexture(ImageIO.read(new URL("https://imgur.com/a/W84LYTB")))));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        CapeUtil.lines = new ArrayList<String>();
    }
}
