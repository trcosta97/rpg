package com.rpg.rpg.characterCreator.model.player;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player-id")
    private Long playerId;
    @Column(name = "player-name")
    private String playerName;
    @Column(name = "sign-date")
    private LocalDateTime signDate;
    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<PlayerCharacter> playerCharactersList = new ArrayList<>();
    @Column(name = "player-status", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean status;

    @PrePersist
    public void prePersist(){
        this.signDate = LocalDateTime.now();
    }

}
