package club.auth.hydraware.setting.settings;

import club.auth.hydraware.setting.*;
import club.auth.hydraware.module.*;

public class SettingBoolean extends Setting
{
    public boolean value;
    
    public SettingBoolean(final String name, final Module mod, final Boolean value) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.type = Setting.Type.BOOLEAN;
    }
    
    public boolean getValue() {
        return this.value;
    }
    
    public void setValue(final boolean value) {
        this.value = value;
    }
}
