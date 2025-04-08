package in.Meghana.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.Meghana.Entity.User;

public interface UserService {
User saveUser(User user);
List<User> findMatches(Long userId);
List<User> getAllData();

User getData(String email,String password);


User getById(Long id);
}
