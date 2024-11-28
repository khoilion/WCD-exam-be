package com.examjava.exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "player_index")
public class PlayerIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @NotNull(message = "Player is mandatory")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "index_id", nullable = false)
    @NotNull(message = "Indexer is mandatory")
    private Indexer indexer;

    @Column(name = "value", nullable = false)
    @NotNull(message = "Value is mandatory")
    private float value;

    public PlayerIndex() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Indexer getIndexer() {
        return indexer;
    }

    public void setIndexer(Indexer indexer) {
        this.indexer = indexer;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
