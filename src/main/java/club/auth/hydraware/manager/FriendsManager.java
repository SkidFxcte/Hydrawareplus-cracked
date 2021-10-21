package club.auth.hydraware.manager;

import java.util.function.*;
import com.google.gson.*;
import java.util.*;

public class FriendsManager
{
    public static final Set<String> FRIENDS;
    
    private FriendsManager() {
    }
    
    public static boolean isFriend(final String name) {
        return FriendsManager.FRIENDS.stream().anyMatch(f -> f.equalsIgnoreCase(name));
    }
    
    public static boolean addFriend(final String name) {
        return !FriendsManager.FRIENDS.contains(name) && FriendsManager.FRIENDS.add(name);
    }
    
    public static boolean removeFriend(final String name) {
        return FriendsManager.FRIENDS.contains(name) && FriendsManager.FRIENDS.remove(name);
    }
    
    public static void removeAllFriends() {
        FriendsManager.FRIENDS.clear();
    }
    
    public static JsonArray serialize() {
        final JsonArray result = new JsonArray();
        FriendsManager.FRIENDS.forEach(result::add);
        return result;
    }
    
    public static void deserialize(final JsonArray array) {
        array.forEach(f -> FriendsManager.FRIENDS.add(f.getAsString()));
    }
    
    static {
        (FRIENDS = new HashSet<String>()).add("bergher");
        FriendsManager.FRIENDS.add("Sudmarinz");
        FriendsManager.FRIENDS.add("AuthX");
    }
}
