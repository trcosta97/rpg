package com.rpg.rpg.characterCreator.service;

import com.rpg.rpg.characterCreator.model.player.Player;
import com.rpg.rpg.characterCreator.model.player.PlayerRepository;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerCharacterRepository playerCharacterRepository;

    public Player save(Player newPlayer){
       return playerRepository.save(newPlayer);
    }

    public Player getById(Long id){
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        return optionalPlayer.orElse(null);
    }

    public Player update(Long id, Player inputPlayer){
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if(optionalPlayer.isPresent()){
            Player existingPlayer = optionalPlayer.get();
            if(inputPlayer.getPlayerName() != null){
                existingPlayer.setPlayerName(inputPlayer.getPlayerName());
            }
            if(inputPlayer.getSignDate() != null){
                existingPlayer.setSignDate(inputPlayer.getSignDate());
            }
            if(inputPlayer.getPlayerCharactersList() != null){
                existingPlayer.setPlayerCharactersList(inputPlayer.getPlayerCharactersList());
            }
            playerRepository.save(existingPlayer);
            return existingPlayer;
        }
        throw new EntityNotFoundException();
    }

    public List<PlayerCharacter> addCharacter(Long id, PlayerCharacter playerCharacter) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.addNewCharacter(playerCharacter);
            playerCharacter.setPlayer(player);
            playerCharacterRepository.save(playerCharacter);
            playerRepository.save(player);
            return player.getPlayerCharactersList();
        }
        return null;
    }




    public Player deactivate(Long id){
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()){
            Player player = optionalPlayer.get();
            player.deactivate();
            return playerRepository.save(player);
        }
        throw new EntityNotFoundException();
    }


}
