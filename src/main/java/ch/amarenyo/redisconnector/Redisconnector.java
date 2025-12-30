package ch.amarenyo.redisconnector;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.bukkit.plugin.java.JavaPlugin;

public final class Redisconnector extends JavaPlugin {

    RedisURI uri = RedisURI.Builder
            .redis("localhost", 6379)
            .build();

    RedisClient client = RedisClient.create(uri);
    StatefulRedisConnection<String, String> connection = client.connect();
    RedisCommands<String, String> commands = connection.sync();

    @Override
    public void onEnable() {
        System.out.println("RedisConnector has been changed; Plugin has been enabled!");

        commands.set("hello", "world");
        String result = commands.get("hello");
        System.out.println(result);

    }

    @Override
    public void onDisable() {
        connection.close();
        client.shutdown();
    }
}
