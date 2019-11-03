package no.knowit.spring.springtutorial.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class MeldingRepositoryTest {
    @Autowired
    private MeldingRepository repository;

    @Test
    void findByType() {
        assertTrue(repository.save(new Melding("", Type.INTERN)).getId() > 0);
        Melding melding = repository.findByType(Type.INTERN);
        assertTrue(melding::hasId);
        assertEquals(Type.INTERN, melding.getType());
    }
}