package no.knowit.spring.springtutorial.web;

import no.knowit.spring.springtutorial.data.Melding;
import no.knowit.spring.springtutorial.data.MeldingRepository;
import no.knowit.spring.springtutorial.data.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
class MeldingControllerTest {
    @Autowired
    private MeldingController controller;
    @Autowired
    private MeldingRepository repository;

    @Test
    void hentMeldingerForType() {
        final String json = "{\"test\"}";
        assertNotNull(repository.save(new Melding(json,Type.EKSTERN)));
        List<Melding> melding = controller.getMeldinger();
        assertEquals(1, melding.size());
        assertEquals(melding.get(0).getType(), Type.EKSTERN);
    }
}