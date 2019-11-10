package no.knowit.spring.springtutorial

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class SpringTutorialApplicationTests {

    @LocalServerPort
    var port: Int = 0

    @Test
    fun contextLoads() {
        WebClient.builder().build()
                .get()
                .uri("http://localhost:$port/tjenesteregister/dev")
                .exchange()
                .blockOptional()
                .ifPresentOrElse({ clientResponse ->
                    val res = clientResponse.bodyToMono<String>(String::class.java)
                    print(res.block())
                }, { System.err.println("inside runnable") })

    }

}
