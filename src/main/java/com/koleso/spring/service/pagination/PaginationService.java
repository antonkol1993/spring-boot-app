package com.koleso.spring.service.pagination;

public interface PaginationService {

    int getPageSize();

    int getTotalPageCount(int records);
}
