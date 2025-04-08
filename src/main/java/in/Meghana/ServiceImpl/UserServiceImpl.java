package in.Meghana.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Meghana.Entity.User;
import in.Meghana.Repository.UserRepo;
import in.Meghana.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	@Override
	public User saveUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public List<User> getAllData() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getData(String email, String password) {
		// TODO Auto-generated method stub
		return repo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<User> findMatches(Long userId) {
		// TODO Auto-generated method stub
		
		    // Get the current user
		    User currentUser = repo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
System.out.println(currentUser.getEmail());
		    // Get all users
		    List<User> allUsers = repo.findAll();

		    // Filter and sort users based on rules
		    List<User> matchedUsers = allUsers.stream()
		        .filter(user -> !user.getEmail().equalsIgnoreCase(currentUser.getEmail())) // Exclude self
		        .filter(user -> !user.getGender().equalsIgnoreCase(currentUser.getGender())) // Opposite gender
		        .filter(user -> hasCommonInterest(user, currentUser)) // At least one common interest
		        .sorted(Comparator.comparingInt(user -> Math.abs(user.getAge() - currentUser.getAge()))) 
//		        // sorted(...)
//
//This is a stream operation that sorts the list based on the given comparison rule.
//Comparator.comparingInt(...)
//
//This creates a comparator to compare two users based on an integer value.
		        .toList();

		    return matchedUsers;
		}


	
	// Helper method to check common interests
	private    boolean hasCommonInterest(User user1, User user2) {
		    System.out.println("User1 Interests: " + user1.getInterests());
		    System.out.println("User2 Interests: " + user2.getInterests());
		 if (user1.getInterests() == null || user2.getInterests() == null) {
		        return false; // ✅ Prevent NullPointerException
		    }
		 
		    return user1.getInterests().stream().anyMatch(user2.getInterests()::contains);
		    //any match is used to check whether atleast one data is present or or not present in the Stream API
		    //collection1.stream().anyMatch(collection2::contains);

		}
	
	
	public User getById(Long id)
	{
		return repo.findOneUserById(id);
	}
	
}