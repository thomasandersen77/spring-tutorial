package no.knowit.spring.springtutorial.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Melding() {
    lateinit var type: Type
    lateinit var json: String

    constructor(json : String, type: Type) :this() {
        this.json = json
        this.type = type
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun hasId(): Boolean {
        return id != null
    }
}
