package codegym.springcasestudy.service;

import codegym.springcasestudy.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Contract findById(Long contractId);
    void save(Contract contract);
    void delete(Long contractId);
}
