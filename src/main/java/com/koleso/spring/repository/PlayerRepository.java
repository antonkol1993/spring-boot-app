package com.koleso.spring.repository;

import com.koleso.spring.dto.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByName(String name);

    Optional<List<Player>> findByAgeLessThanEqualAndPosition(Integer age, String position);

    @Query("""
            SELECT p FROM Player p
            WHERE p.position = :position
                AND p.name = :name
            """)
    List<Player> getAwesomePlayers(String position, String name);

}
