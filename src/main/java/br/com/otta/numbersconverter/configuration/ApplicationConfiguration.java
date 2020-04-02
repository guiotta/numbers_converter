package br.com.otta.numbersconverter.configuration;

import java.io.Console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe para realizar configurações no Container Spring da aplicação.
 *
 * @author Guilherme
 *
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public Console console() {
        return System.console();
    }
}
