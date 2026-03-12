package br.com.msp.findurbuddy.adapter.output.persistence.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.*;
import lombok.*;

import java.net.URL;

@Entity
@Table(name = "dogs")
@NoArgsConstructor
@Getter
@Setter
public class DogEntity {
    @Id
    private String id;
    private String name;
    private String breed;
    private String age;
    private String gender;
    private String details;
    private URL photoUrl;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private HomeEntity home;

    public DogEntity(String name, String breed, String age, String gender, String details, URL photoUrl,
                     HomeEntity home) {
        this.id = UlidCreator.getUlid().toString();
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.details = details;
        this.photoUrl = photoUrl;
        this.home = home;
    }
}
