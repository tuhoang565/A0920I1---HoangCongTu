package codegym.springcasestudy.service;

import codegym.springcasestudy.model.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();
    AttachService findById(Long id);
    void save(AttachService attachService);
    void delete(Long id);
}
