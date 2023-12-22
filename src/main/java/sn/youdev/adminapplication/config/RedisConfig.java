package sn.youdev.adminapplication.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import sn.youdev.adminapplication.service.AppRoleService;

@ConditionalOnProperty(prefix = "spring", name = "cache.type", havingValue = "redis")
@Configuration
@Import({ RedisAutoConfiguration.class })
public class RedisConfig {
    private final AppRoleService service;

    public RedisConfig(AppRoleService service) {
        this.service = service;
    }
}
