package br.com.msp.findurbuddy.adapter.output.persistence.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "homes")
@NoArgsConstructor
@Getter
@Setter
public class HomeEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private String address;
    private String city;
    private String state;
    private String phone;

    @OneToMany(mappedBy = "home")
    private List<DogEntity> dogEntities;

    public HomeEntity(String name, String description, String address, String city, String state,
                      String phone) {
        this.id = UlidCreator.getUlid().toString();
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
    }
}
