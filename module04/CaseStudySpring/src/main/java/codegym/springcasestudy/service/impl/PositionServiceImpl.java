package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.Position;
import codegym.springcasestudy.repository.PositionRepository;
import codegym.springcasestudy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }
}
