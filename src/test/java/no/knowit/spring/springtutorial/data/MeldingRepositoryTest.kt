package no.knowit.spring.springtutorial.data

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.assertTrue

@DataJpaTest
open class MeldingRepositoryTest {
    @Autowired
    private val repository: MeldingRepository? = null

    @Test
    fun findByType() {
        assertTrue { repository!!.save(Melding("", Type.INTERN)).id!! > 0 }
        val melding = repository!!.findByType(Type.INTERN)
        assertTrue( melding.hasId() )
        assertEquals(Type.INTERN, melding.type)
    }
}