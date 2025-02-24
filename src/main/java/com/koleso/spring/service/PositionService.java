package com.koleso.spring.service;

import com.koleso.spring.objects.Position;

import java.util.List;

public interface PositionService {

    List<Position> getPositionsFromPage(int page, int pageSize);

    List<Position> getAllPositions();

    int getAllPositionsCount();

    Position getPositionById(Long id);

    List<Position> getPositionByName(String name);

    void addPosition(Position Position);

    void removePosition(Long id);

    void updatePosition(Position position);
}
