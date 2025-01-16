package com.koleso.spring.service.pagination_service;

public interface PaginationService {

    int getPageSize();

    int getTotalPageCount(int records);
}
