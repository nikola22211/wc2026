package org.primer.wc2026api;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.flyway.autoconfigure.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Wc2026ApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(Wc2026ApiApplication.class, args);

    }

}
