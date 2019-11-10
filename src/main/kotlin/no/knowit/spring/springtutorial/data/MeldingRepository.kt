package no.knowit.spring.springtutorial.data

import org.springframework.data.jpa.repository.JpaRepository

interface MeldingRepository : JpaRepository<Melding, Long> {
    fun findByType(type: Type): Melding
}
