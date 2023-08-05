package com.rpg.rpg.characterCreator.model.playerCharacter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rpg.rpg.characterCreator.model.characterStats.CharacterStats;
import com.rpg.rpg.characterCreator.model.player.Player;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "player-character")
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long characterId;
    @Column(name = "character-name", nullable = false)
    private String characterName;
    @Column(name = "character-gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private CharacterGender characterGender;
    @Column(name = "character-age", nullable = false,scale = 4)
    private int characterAge;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "stats_id")
    private CharacterStats characterStats;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;
    @Enumerated(EnumType.STRING)
    @Column(name = "character_race", nullable = false)
    private CharacterRace race;
    @Column(name = "character_status",  columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean status;
    @Column(name = "character_creation")
    private LocalDateTime creationDate;

    @PrePersist
    protected void prePersist(){
        this.creationDate = LocalDateTime.now();
        this.status = true;
    }
}
