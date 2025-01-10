package com.koleso.spring.service.person_service;

import com.koleso.spring.dto.Person;
import com.koleso.spring.repository.PersonRepository;
import com.koleso.spring.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PaginationService paginationService;


    @Override
    public List<Person> getPersons() {
        int pageSize = paginationService.getPageSize();
        List<Person> persons = personRepository.findAll();
        int fromIndex = 0;
        int toIndex = fromIndex + pageSize;
        if (toIndex > persons.size()) {
            toIndex = persons.size();
        }
        persons = persons.subList(fromIndex, toIndex);
        return persons;
    }

    @Override
    public List<Person> getPersons(int page, int pageSize) {
        List<Person> persons = personRepository.findAll();
        int fromIndex = (page-1) * pageSize;
        int toIndex = fromIndex + pageSize;
        if (toIndex > persons.size()) {
            toIndex = persons.size();
        }
        persons = persons.subList(fromIndex, toIndex);
        return persons;
    }

    @Override
    public int getAllPersonsCount() {
        return personRepository.findAll().size();
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    public void addPerson(Person person) {

    }

    @Override
    public void removePerson(Long id) {

    }

    @Override
    public void updatePerson(Person person) {

    }


//    @Override
//    public List<Player> getPlayers(int page, int pageSize) {
//
//        List<Player> players = playerRepository.findAll();
//        int fromIndex = (page-1) * pageSize;
//        int toIndex = fromIndex + pageSize;
//        if (toIndex > players.size()) {
//            toIndex = players.size();
//        }
//        players = players.subList(fromIndex, toIndex);
//        return players;
//    }
//
//    @Override
//    public int getAllPlayersCount() {
//        return playerRepository.findAll().size();
//    }
//
//    @Override
//    public Player getPlayerById(Long id) {
//        return playerRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    public void addPlayer(Player player) {
//        playerRepository.save(player);
//    }
//
//    @Override
//    public void removePlayer(Long id) {
//        playerRepository.deleteById(id);
//    }
//
//    @Override
//    public void updatePlayer(Player player) {
//        playerRepository.save(player);
//    }
}
