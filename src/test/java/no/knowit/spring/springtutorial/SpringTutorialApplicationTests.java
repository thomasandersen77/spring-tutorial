package no.knowit.spring.springtutorial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringTutorialApplicationTests {

    @LocalServerPort
    int port;

    @Test
    void contextLoads() {
        WebClient.builder().build()
                .get()
                .uri("http://localhost:"+port+"/tjenesteregister/dev")
                .exchange()
                .blockOptional()
                .ifPresentOrElse(clientResponse -> {
					Mono<String> res = clientResponse.bodyToMono(String.class);
					System.out.println(res.block());
                }, () -> {
                    System.err.println("inside runnable");
                });

    }

}
