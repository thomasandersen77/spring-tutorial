package no.knowit.spring.springtutorial.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Melding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String json;
    @Enumerated(EnumType.STRING)
    private Type type;

    public Melding(@NonNull String json, @NonNull Type type) {
        this.json = json;
        this.type = type;
    }

    public boolean hasId() {
        return id > 0;
    }
}
