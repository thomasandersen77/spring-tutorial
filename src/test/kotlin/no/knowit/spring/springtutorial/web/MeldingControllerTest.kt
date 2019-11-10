package no.knowit.spring.springtutorial.web

import no.knowit.spring.springtutorial.data.Melding
import no.knowit.spring.springtutorial.data.MeldingRepository
import no.knowit.spring.springtutorial.data.Type
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureTestDatabase
internal class MeldingControllerTest {
    @Autowired lateinit var repository: MeldingRepository
    @Autowired lateinit var controller: MeldingController

    @Test
    fun hentMeldingerForType() {
        val json = "{\"test\"}"
        assertNotNull(repository.save(Melding(json, Type.EKSTERN)))
        val melding = controller.meldinger
        assertEquals(1, melding.size)
        assertEquals(melding[0].type, Type.EKSTERN)
    }
}