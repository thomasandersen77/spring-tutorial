package no.knowit.spring.springtutorial.web;

import no.knowit.spring.springtutorial.data.Melding;
import no.knowit.spring.springtutorial.data.MeldingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class MeldingController {
    private MeldingRepository meldingRepository;

    public MeldingController(MeldingRepository meldingRepository) {
        this.meldingRepository = meldingRepository;
    }

    @GetMapping("melding")
    public List<Melding> getMeldinger(){
        return meldingRepository.findAll();
    }
}
