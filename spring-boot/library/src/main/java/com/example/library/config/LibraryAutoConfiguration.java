package com.example.library.config;

import com.example.library.property.LibraryProperties;
import com.example.library.property.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example.library.*")
@EnableConfigurationProperties(LibraryProperties.class)
@PropertySource(value = "classpath:application-library.yml", factory = YamlPropertySourceFactory.class)
public class LibraryAutoConfiguration {
}
