package club.auth.hydraware.setting.settings;

import club.auth.hydraware.setting.*;
import club.auth.hydraware.module.*;

public class SettingInteger extends Setting
{
    public int value;
    public int min;
    public int max;
    
    public SettingInteger(final String name, final Module mod, final int value, final int min, final int max) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.min = min;
        this.max = max;
        this.type = Setting.Type.INTEGER;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(final int value) {
        this.value = value;
    }
    
    public int getMin() {
        return this.min;
    }
    
    public void setMin(final int min) {
        this.min = min;
    }
    
    public int getMax() {
        return this.max;
    }
    
    public void setMax(final int max) {
        this.max = max;
    }
}
