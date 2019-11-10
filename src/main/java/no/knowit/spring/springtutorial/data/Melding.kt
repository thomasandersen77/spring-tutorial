package no.knowit.spring.springtutorial.data

import lombok.NonNull
import javax.persistence.*

@Entity
class Melding(@NonNull val json: String, @NonNull @Enumerated(EnumType.STRING) val type: Type) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun hasId(): Boolean {
        return id != null
    }
}
