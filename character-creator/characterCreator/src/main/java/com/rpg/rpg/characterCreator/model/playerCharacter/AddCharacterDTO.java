package com.rpg.rpg.characterCreator.model.playerCharacter;

import com.rpg.rpg.characterCreator.model.characterStats.CharacterStats;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddCharacterDTO(
        @NotBlank
        String characterName,
        @NotBlank
        CharacterGender characterGender,
        @NotBlank
        ClassType classType,
        @NotBlank
        CharacterRace race,
        @NotNull
        int characterAge


) {
}
