package service.impl;




import model.CustomerType;
import repository.CustomerTypeRepository;
import repository.CustomerTypeRepositoryImpl;
import service.CustomerTypeService;

import java.util.List;


public class CustomerTypeServiceImpl implements CustomerTypeService {

    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl() ;

    @Override
    public List<CustomerType> getAll() {
        return customerTypeRepository.selectAllCustomerType();
    }

    @Override
    public CustomerType getCusTypeById(int id) {
        return customerTypeRepository.selectTypeNote(id);
    }
}
