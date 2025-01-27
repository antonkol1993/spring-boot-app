package com.koleso.spring.service.pagination;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.yaml", ignoreResourceNotFound = true)
public class PaginationServiceImpl implements PaginationService {
    @Value("${spring.application.settings.pageSize}")
    private int pageSize;

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPageCount(int records) {
        if (records < getPageSize()) {
            return 1;
        } else if (records % getPageSize() > 0) {
            return (records / getPageSize()) + 1;
        }
        return records / getPageSize();
    }

}



