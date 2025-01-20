package com.koleso.spring.service;

import com.koleso.spring.dto.Position;
import com.koleso.spring.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;


    @Override
    public List<Position> getPositions(int page, int pageSize) {
        Page<Position> positions = positionRepository.findAll(PageRequest.of(page, pageSize));
        return positions.getContent();
    }

    @Override
    public int getAllPositionsCount() {
        return positionRepository.findAll().size();
    }

    @Override
    public Position getPositionById(Long id) {
        Optional<Position> positionById = positionRepository.findById(id);
        return positionById.orElseThrow();
    }

    @Override
    public List<Position> getPositionByName(String name) {
        return positionRepository.findAllByName(name);
    }

    @Override
    public void addPosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void removePosition(Long id) {
    positionRepository.deleteById(id);
    }

    @Override
    public void updatePosition(Position position) {
        positionRepository.save(position);
    }
}
