package com.rpg.rpg.characterCreator.model.characterStats;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import jakarta.persistence.*;
import lombok.*;

import java.util.Random;

@Entity
@Table(name = "stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "statsId")
public class CharacterStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long statsId;
    @Column(name = "intelligence", nullable = false, scale = 3)
    private int intelligence = generateRandomInt();
    @Column(name = "strength", nullable = false, scale = 3)
    private int strength = generateRandomInt();
    @Column(name = "dexterity", nullable = false, scale = 3)
    private int dexterity = generateRandomInt();
    @Column(name = "constitution", nullable = false, scale = 3)
    private int constitution = generateRandomInt();
    @Column(name = "charisma", nullable = false, scale = 3)
    private int charisma = generateRandomInt();
    @Column(name = "luck", nullable = false, scale = 3)
    private int luck = generateRandomInt();
    @OneToOne
    @JoinColumn(name = "player_character_id")
    @JsonManagedReference
    private PlayerCharacter playerCharacter;


    public static int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(21);
    }

}
