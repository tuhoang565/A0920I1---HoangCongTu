package service;




import model.CustomerType;

import java.util.List;

public interface CustomerTypeService {

     List<CustomerType> getAll();

     CustomerType getCusTypeById(int id);
}
