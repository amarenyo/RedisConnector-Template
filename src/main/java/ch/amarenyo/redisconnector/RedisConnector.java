package ch.amarenyo.redisconnector;

import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.RedisClient;

import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class RedisConnector extends JavaPlugin {

    RedisClient redis = RedisClient.builder().hostAndPort("localhost", 6379).build();

    @Override
    public void onEnable() {

        String ping = redis.ping();
        getLogger().info(ping);


        redis.sadd("information_getter", "HELLO WORLD");

        ExecutorService executor;
        executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            try (Jedis jedis = new Jedis()) {

                jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {



                }
            }, "channel");
            }
        });
    }

    @Override
    public void onDisable() {
        redis.close();
    }
}
