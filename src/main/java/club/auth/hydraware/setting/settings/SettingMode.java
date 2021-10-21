package club.auth.hydraware.setting.settings;

import club.auth.hydraware.setting.*;
import java.util.*;
import club.auth.hydraware.module.*;

public class SettingMode extends Setting
{
    public String value;
    public ArrayList<String> values;
    public int index;
    
    public SettingMode(final String name, final Module mod, final ArrayList<String> values, final String value) {
        this.name = name;
        this.mod = mod;
        this.values = values;
        this.value = value;
        this.type = Setting.Type.MODE;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String value) {
        this.value = value;
    }
    
    public ArrayList<String> getValues() {
        return this.values;
    }
    
    public void setValues(final ArrayList<String> values) {
        this.values = values;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    public void increment() {
        ++this.index;
        if (this.index > this.values.size() - 1) {
            this.index = 0;
        }
        if (this.index < 0) {
            this.index = this.values.size() - 1;
        }
        this.value = this.values.get(this.index);
    }
    
    public void decrement() {
        --this.index;
        if (this.index < 0) {
            this.index = this.values.size() - 1;
        }
        this.value = this.values.get(this.index);
    }
}
