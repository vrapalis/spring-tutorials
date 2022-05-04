package com.example.library.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "com.example.library")
public class LibraryProperties {

    /**
     * Greeting msg.
     */
    @NotNull
    @NotEmpty
    private String greeting;
}
