package com.rpg.rpg.characterCreator.controller;

import com.rpg.rpg.characterCreator.model.characterStats.CharacterStats;
import com.rpg.rpg.characterCreator.model.player.Player;
import com.rpg.rpg.characterCreator.model.player.PostUserDTO;
import com.rpg.rpg.characterCreator.model.playerCharacter.AddCharacterDTO;
import com.rpg.rpg.characterCreator.model.playerCharacter.PlayerCharacter;
import com.rpg.rpg.characterCreator.service.PlayerCharacterService;
import com.rpg.rpg.characterCreator.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerCharacterService playerCharacterService;

    @PostMapping("/player")
    public ResponseEntity<Player> save(@RequestBody @Valid PostUserDTO data, UriComponentsBuilder uriBuilder){
        var newPlayer = new Player(data);
        Player savedPlayer = playerService.save(newPlayer);
        var uri = uriBuilder.path("/player/{id}").buildAndExpand(savedPlayer.getPlayerId()).toUri();
        return ResponseEntity.created(uri).body(savedPlayer);
    }

    @PostMapping("/player/{id}")
    public ResponseEntity<List<PlayerCharacter>> addCharacter(@RequestBody @Valid AddCharacterDTO data, @PathVariable Long id){
        PlayerCharacter newPlayerCharacter = new PlayerCharacter(data);

        var player = playerService.getById(id);
        playerService.addCharacter(id,newPlayerCharacter);

        return ResponseEntity.ok(player.getPlayerCharactersList());
    }

}
