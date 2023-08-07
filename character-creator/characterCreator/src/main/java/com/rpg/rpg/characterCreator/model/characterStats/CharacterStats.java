package com.rpg.rpg.characterCreator.model.characterStats;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "stats")
public class CharacterStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long statsId;
    @Column(name = "intelligence", nullable = false, scale = 3)
    private int intelligence;
    @Column(name = "strength", nullable = false, scale = 3)
    private int strength;
    @Column(name = "dexterity", nullable = false, scale = 3)
    private int dexterity;
    @Column(name = "constitution", nullable = false, scale = 3)
    private int constitution;
    @Column(name = "charisma", nullable = false, scale = 3)
    private int charisma;
    @Column(name = "luck", nullable = false, scale = 3)
    private int luck;
    @PrimaryKeyJoinColumn(name = "character_id")
    @OneToOne(mappedBy = "characterStats")
    private PlayerCharacter playerCharacter;

    public int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(21);
    }

    @PrePersist
    public void randomizeStat(){
        this.charisma = generateRandomInt();
        this.constitution = generateRandomInt();
        this.luck = generateRandomInt();
        this.dexterity = generateRandomInt();
        this.strength = generateRandomInt();
        this.intelligence = generateRandomInt();
    }

}
