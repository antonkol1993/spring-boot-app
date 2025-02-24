package com.koleso.spring.repository;

import com.koleso.spring.objects.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByName(String name);


    @Query("""
            SELECT p FROM Player p
            WHERE p.position = :position
                AND p.name = :name
            """)
    List<Player> getAwesomePlayers(String position, String name);

}
