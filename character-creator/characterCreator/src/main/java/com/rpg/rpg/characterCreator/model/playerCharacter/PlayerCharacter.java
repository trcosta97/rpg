package com.rpg.rpg.characterCreator.model.playerCharacter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rpg.rpg.characterCreator.model.characterStats.CharacterStats;
import com.rpg.rpg.characterCreator.model.player.Player;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "player_character")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "characterId")
@JsonIgnoreProperties("playerCharactersList")
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long characterId;
    @Column(name = "name", nullable = false)
    private String characterName;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private CharacterGender characterGender;
    @Column(name = "age", nullable = false,scale = 4)
    private int characterAge;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id")
    @JsonBackReference
    private CharacterStats characterStats;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;
    @Enumerated(EnumType.STRING)
    @Column(name = "race", nullable = false)
    private CharacterRace race;
    @Enumerated(EnumType.STRING)
    @Column(name = "class", nullable = false)
    private ClassType classType;
    @Column(name = "status",  columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean status;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public PlayerCharacter(AddCharacterDTO data) {
        this.characterName = data.characterName();
        this.characterGender = data.characterGender();
        this.characterAge = data.characterAge();
        this.classType = data.classType();
        this.race = data.race();
    }

    @PrePersist
    protected void prePersist(){
        this.creationDate = LocalDateTime.now();
        this.status = true;
        this.characterStats = new CharacterStats();


    }

}
