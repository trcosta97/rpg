package com.rpg.rpg.characterCreator.model.player;

import jakarta.validation.constraints.NotBlank;

public record PostUserDTO(
        @NotBlank
        String playerName) {
}
