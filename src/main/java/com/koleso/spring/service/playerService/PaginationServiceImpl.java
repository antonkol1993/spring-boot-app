package com.koleso.spring.service.playerService;

import org.springframework.stereotype.Service;

@Service
public class PaginationServiceImpl implements PaginationService {

    @Override
    public int getPageSize() {
        return 10;
    }

    @Override
    public int getActualPageCount(int records) {
        return 10;
    }
}
