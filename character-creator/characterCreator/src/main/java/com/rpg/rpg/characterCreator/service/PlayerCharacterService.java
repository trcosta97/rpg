package com.rpg.rpg.characterCreator.service;

import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerCharacterService {

    @Autowired
    private PlayerCharacterRepository playerCharacterRepository;

    public PlayerCharacter save(PlayerCharacter newPlayerCharacter){
      return playerCharacterRepository.save(newPlayerCharacter);
    }
}
