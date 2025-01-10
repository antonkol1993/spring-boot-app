package com.koleso.spring.service.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


// for pass some quantity of objects to html page
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuantity {
    private int numberOfPage;

}
