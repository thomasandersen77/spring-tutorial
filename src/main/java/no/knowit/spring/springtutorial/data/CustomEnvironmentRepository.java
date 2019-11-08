package no.knowit.spring.springtutorial.data;

import jdk.jfr.Registered;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.environment.NativeEnvironmentProperties;
import org.springframework.cloud.config.server.environment.NativeEnvironmentRepository;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomEnvironmentRepository extends NativeEnvironmentRepository {
    public CustomEnvironmentRepository(ConfigurableEnvironment environment, NativeEnvironmentProperties properties) {
        super(environment, properties);
        this.setSearchLocations(properties.getSearchLocations());
    }

    @Override
    public Environment findOne(String config, String profile, String label) {
        return super.findOne(config, profile, label);
    }

    @Override
    public void setSearchLocations(String... locations) {
        try {
            Path root = Path.of(locations[0].substring(locations[0].indexOf(":") + 1));
            String[] locations1 = Files.walk(root)
                    .filter(Files::isDirectory)
                    .map(Path::toString).toArray(String[]::new);
            super.setSearchLocations(locations1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
