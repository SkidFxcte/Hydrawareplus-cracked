package club.auth.hydraware.setting;

import club.auth.hydraware.module.*;
import java.util.*;

public class SettingsManager
{
    public ArrayList<Setting> settings;
    
    public SettingsManager() {
        this.settings = new ArrayList<Setting>();
    }
    
    public ArrayList<Setting> getSettingsInMod(final Module mod) {
        final ArrayList<Setting> sets = new ArrayList<Setting>();
        for (final Setting s : this.settings) {
            if (s.getMod() == mod) {
                sets.add(s);
            }
        }
        return sets;
    }
    
    public void setSettings(final ArrayList<Setting> settings) {
        this.settings = settings;
    }
}
