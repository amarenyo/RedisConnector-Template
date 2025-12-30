package ch.amarenyo.redisconnector;

import org.bukkit.plugin.java.JavaPlugin;

public final class Redisconnector extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("RedisConnector has been changed; Plugin has been enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
