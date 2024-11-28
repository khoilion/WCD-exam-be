package com.examjava.exam.controller;

import com.examjava.exam.model.Indexer;
import com.examjava.exam.model.Player;
import com.examjava.exam.repository.IndexerRepository;
import com.examjava.exam.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private IndexerRepository indexerRepository;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player playerRequest) {

        Optional<Indexer> indexerOpt = indexerRepository.findById(playerRequest.getIndexer().getIndexId());
        if (indexerOpt.isPresent()) {
            playerRequest.setIndexer(indexerOpt.get());
            Player savedPlayer = playerRepository.save(playerRequest);
            return ResponseEntity.ok(savedPlayer);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        Optional<Player> playerOpt = playerRepository.findById(id);
        return playerOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @Valid @RequestBody Player playerDetails) {
        Optional<Player> playerOpt = playerRepository.findById(id);
        if (playerOpt.isPresent()) {
            Player player = playerOpt.get();
            player.setName(playerDetails.getName());
            player.setFullName(playerDetails.getFullName());
            player.setAge(playerDetails.getAge());

            // Cập nhật Indexer
            Optional<Indexer> indexerOpt = indexerRepository.findById(playerDetails.getIndexer().getIndexId());
            if (indexerOpt.isPresent()) {
                player.setIndexer(indexerOpt.get());
            } else {
                return ResponseEntity.badRequest().build();
            }

            Player updatedPlayer = playerRepository.save(player);
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        Optional<Player> playerOpt = playerRepository.findById(id);
        if (playerOpt.isPresent()) {
            playerRepository.delete(playerOpt.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
//aa