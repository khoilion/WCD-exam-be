package com.examjava.exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "name", nullable = false, length = 64)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "full_name", nullable = false, length = 128)
    @NotBlank(message = "Full name is mandatory")
    private String fullName;

    @Column(name = "age", nullable = false, length = 10)
    @NotBlank(message = "Age is mandatory")
    private String age;

    @ManyToOne
    @JoinColumn(name = "index_id", nullable = false)
    private Indexer indexer;

    @OneToMany(mappedBy = "player")
    private Set<PlayerIndex> playerIndexes;

    public Player() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Indexer getIndexer() {
        return indexer;
    }

    public void setIndexer(Indexer indexer) {
        this.indexer = indexer;
    }

    public Set<PlayerIndex> getPlayerIndexes() {
        return playerIndexes;
    }

    public void setPlayerIndexes(Set<PlayerIndex> playerIndexes) {
        this.playerIndexes = playerIndexes;
    }
}
