package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.Contract;
import codegym.springcasestudy.repository.ContractRepository;
import codegym.springcasestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long contractId) {
        return contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void delete(Long contractId) {
        contractRepository.deleteById(contractId);
    }
}
