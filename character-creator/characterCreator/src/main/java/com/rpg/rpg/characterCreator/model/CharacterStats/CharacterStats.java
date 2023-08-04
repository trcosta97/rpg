package com.rpg.rpg.characterCreator.model.CharacterStats;

import jakarta.persistence.*;

@Entity
@Table(name = "character-stats")
public class CharacterStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stats-id")
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


}
