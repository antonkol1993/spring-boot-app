package com.koleso.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Player {


    private Integer id;

    private String name;

    private Integer age;

    private String country;

    private String position;

    private String rating;
}
