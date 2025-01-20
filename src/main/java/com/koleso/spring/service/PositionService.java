package com.koleso.spring.service;

import com.koleso.spring.dto.Position;

import java.util.List;

public interface PositionService {

    List<Position> getPositions(int page, int pageSize);

    int getAllPositionsCount();

    Position getPositionById(Long id);
    List<Position> getPositionByName(String name);

    void addPosition(Position Position);

    void removePosition(Long id);

    void updatePosition(Position position);
}
