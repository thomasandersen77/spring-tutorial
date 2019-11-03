package no.knowit.spring.springtutorial.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeldingRepository extends JpaRepository<Melding, Long> {
    Melding findByType(Type type);
}
