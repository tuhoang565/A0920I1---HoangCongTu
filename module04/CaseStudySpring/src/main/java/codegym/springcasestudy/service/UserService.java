package codegym.springcasestudy.service;

import codegym.springcasestudy.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(Long id);

    UserDetails loadUserByUsername(String username);

    @Query("select u.userId from User u where u.username = ?1")
    Long getUserIdByUsername(String username);

    Boolean checkExistUser(String username);
}
