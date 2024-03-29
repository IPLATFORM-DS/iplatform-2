package space.eliseev.iplatform.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "config")
@Getter
@Setter
@PropertySource(value = "classpath:api-info.yml", factory = YamlPropertySourceFactory.class)
public class StockConfig {
    private List<String> urls;
}


