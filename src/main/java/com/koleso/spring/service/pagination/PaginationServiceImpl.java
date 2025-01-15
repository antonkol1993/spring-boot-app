package com.koleso.spring.service.pagination;

import com.koleso.spring.dto.Player;
import com.koleso.spring.service.player_service.PlayerService;
import com.koleso.spring.service.player_service.PlayerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public int getTotalPageCount(int records) {
        return (records / getPageSize()) + 1;
    }


}
