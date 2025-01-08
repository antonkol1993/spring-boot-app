package com.koleso.spring.service.playerService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:application.yaml", ignoreResourceNotFound = true)
public class PaginationServiceImpl implements PaginationService {
    @Value("${spring.application.settings.pageSize}")
    private String pageSize;
    private PlayerService playerService;

    @Override
    public int getPageSize() {
        return Integer.parseInt(pageSize);
    }

    @Override
    public int getActualPageCount(int records) {
        int allPlayersCount = playerService.getAllPlayersCount();
        if (allPlayersCount<getPageSize()) {
            return 0;
        }
        return allPlayersCount/getPageSize();
    }
}
