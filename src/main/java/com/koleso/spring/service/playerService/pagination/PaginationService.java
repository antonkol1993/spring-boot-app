package com.koleso.spring.service.playerService.pagination;

import java.util.List;

public interface PaginationService {

    int getPageSize();

    int getTotalPageCountOld(int records);
    public List<PageQuantity> getTotalPageCountNew(int records);
}
