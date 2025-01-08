package com.koleso.spring.service.playerService.pagination;

import java.util.List;

public interface PaginationService {

    int getPageSize();

    public List<PageQuantity> getTotalPageCount(int records);
}
