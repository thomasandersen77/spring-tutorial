package no.knowit.spring.springtutorial

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
open class Main

fun main(args: Array<String>) {
    SpringApplication.run(Main::class.java, *args)
}