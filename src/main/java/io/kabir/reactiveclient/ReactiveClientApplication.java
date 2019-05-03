package io.kabir.reactiveclient;

import io.kabir.reactiveclient.data.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveClientApplication.class, args);
    }

    @Bean
    WebClient client() {
        return WebClient.create();
    }

    @Bean
    CommandLineRunner demoClient(WebClient client) {
        return args -> {
            client
                    .get()
                    .uri("http://localhost:8080/movie-stream")
                    .exchange()
                    .subscribe(clientResponse -> clientResponse
                            .bodyToFlux(Movie.class)
                            .subscribe(System.out::println, null, () -> System.out.println("DONE"))
                    );

        };

    }
}
