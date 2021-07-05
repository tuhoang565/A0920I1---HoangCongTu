package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Position;

public interface PositionService {
    Iterable<Position> findAll();
    Position findById(Long id);
    void save(Position position);
}
