package no.knowit.spring.springtutorial.web

import no.knowit.spring.springtutorial.data.Melding
import no.knowit.spring.springtutorial.data.MeldingRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class MeldingController(private val meldingRepository: MeldingRepository) {

    val meldinger: List<Melding>
        @GetMapping("melding")
        get() = meldingRepository.findAll()
}
