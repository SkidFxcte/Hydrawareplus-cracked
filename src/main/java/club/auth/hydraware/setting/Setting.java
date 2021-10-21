package club.auth.hydraware.setting;

import club.auth.hydraware.module.*;

public class Setting
{
    public String name;
    public Module mod;
    public Type type;
    
    public Type getType() {
        return this.type;
    }
    
    public void setType(final Type type) {
        this.type = type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public Module getMod() {
        return this.mod;
    }
    
    public void setMod(final Module mod) {
        this.mod = mod;
    }
    
    public enum Type
    {
        BOOLEAN, 
        DOUBLE, 
        INTEGER, 
        MODE;
    }
}
