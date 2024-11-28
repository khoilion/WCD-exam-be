package com.examjava.exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "indexer")
public class Indexer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index_id")
    private int indexId;

    @Column(name = "name", nullable = false, length = 64)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "valueMin", nullable = false)
    @NotNull(message = "Value Min is mandatory")
    private float valueMin;

    @Column(name = "valueMax", nullable = false)
    @NotNull(message = "Value Max is mandatory")
    private float valueMax;

    @OneToMany(mappedBy = "indexer")
    private Set<PlayerIndex> playerIndexes;

    public Indexer() {
    }

    public int getIndexId() {
        return indexId;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValueMin() {
        return valueMin;
    }

    public void setValueMin(float valueMin) {
        this.valueMin = valueMin;
    }

    public float getValueMax() {
        return valueMax;
    }

    public void setValueMax(float valueMax) {
        this.valueMax = valueMax;
    }

    public Set<PlayerIndex> getPlayerIndexes() {
        return playerIndexes;
    }

    public void setPlayerIndexes(Set<PlayerIndex> playerIndexes) {
        this.playerIndexes = playerIndexes;
    }
}
