package com.rpg.rpg.characterCreator.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "playerId")
@JsonIgnoreProperties("player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long playerId;
    @Column(name = "name", nullable = false)
    private String playerName;
    @Column(name = "sign_date")
    private LocalDateTime signDate;
    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<PlayerCharacter> playerCharactersList = new ArrayList<>();
    @Column(name = "status", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean status;

    @PrePersist
    public void prePersist() {
        this.signDate = LocalDateTime.now();
        this.status = true;

        for (PlayerCharacter character : playerCharactersList) {
            character.setPlayer(this);
        }
    }

    public void addNewCharacter(PlayerCharacter character) {
        character.setPlayer(this);
        this.playerCharactersList.add(character);
    }


    public void deactivate(){
        this.status = false;
    }

    public Player(PostUserDTO data){
        this.playerName = data.playerName();
    }

}
