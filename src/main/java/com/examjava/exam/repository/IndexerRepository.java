package com.examjava.exam.repository;



import com.examjava.exam.model.Indexer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexerRepository extends JpaRepository<Indexer, Integer> { }
