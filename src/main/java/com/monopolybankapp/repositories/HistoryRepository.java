package com.monopolybankapp.repositories;

import com.monopolybankapp.Entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("select H from History H where H.originId = ?1 or H.destinyId = ?1")
    public List<History> findByOriginIdOrDestinyId(Long id);
}
