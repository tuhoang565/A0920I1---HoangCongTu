package codegym.springcasestudy.service.impl;

import codegym.springcasestudy.model.ContractDetail;
import codegym.springcasestudy.repository.ContractDetailRepository;
import codegym.springcasestudy.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(Long contractDetailId) {
        contractDetailRepository.deleteById(contractDetailId);
    }
}
