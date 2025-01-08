package com.koleso.spring.service.playerService.pagination;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<PageQuantity> getTotalPageCount(int records) {
        Integer pagesCount = records / getPageSize();
        List<PageQuantity> pageQuantityList = new ArrayList<>();

        if (pagesCount == 0) {
            pagesCount = 0;
        } else {
            if (records % getPageSize() != 0) {
                pagesCount = pagesCount + 1;
            }
        }
        for (int i = 0; i < pagesCount; i++) {
            PageQuantity pageQuantity = new PageQuantity();
            pageQuantity.setNumberOfPage(i + 1);
            pageQuantityList.add(pageQuantity);
        }
        return pageQuantityList;
    }


}
