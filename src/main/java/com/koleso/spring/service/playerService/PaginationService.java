package com.koleso.spring.service.playerService;

public interface PaginationService {

    int getPageSize();

    int getTotalPageCount(int records);
}
