package com.koleso.spring.service.playerService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.yaml", ignoreResourceNotFound = true)
public class PaginationServiceImpl implements PaginationService {
    @Value("${spring.application.settings.pageSize}")
    private String pageSize;


    @Override
    public int getPageSize() {
        return Integer.parseInt(pageSize);
    }

    @Override
    public int getTotalPageCount(int records) {
        Integer pagesCount = records / getPageSize();
        if (records / getPageSize() == 0) {
            return 0;
        } else {
            if (records % getPageSize() != 0) {
                return (pagesCount + 1);
            } else {
                return (pagesCount);
            }
        }
    }


}
