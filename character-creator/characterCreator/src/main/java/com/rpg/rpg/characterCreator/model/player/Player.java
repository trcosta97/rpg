package com.rpg.rpg.characterCreator.model.player;

import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import jakarta.persistence.*;

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
    @Column(name = "character-list")
    @OneToMany(mappedBy = "player")
    private List<PlayerCharacter> playerCharactersList;
    @Column(name = "player-status", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean status;

}
