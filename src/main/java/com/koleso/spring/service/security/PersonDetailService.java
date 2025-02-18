//package com.koleso.spring.service.security;
//
//import com.koleso.spring.dto.Person;
//import com.koleso.spring.repository.PersonRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PersonDetailsService implements UserDetailsService {
//    private final PersonRepository personRepository;
//
//    public PersonDetailsService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Person person = personRepository.findPersonByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        return new User(person.getUsername(), person.getPassword(), getAuthorities(person));
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(Person person) {
//        return person.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().name()))
//                .collect(Collectors.toList());
//    }
//}
