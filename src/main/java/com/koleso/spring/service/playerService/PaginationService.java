package com.koleso.spring.service.playerService;

public interface PaginationService {

    int getPageSize();

    int getActualPageCount(int records);

}
