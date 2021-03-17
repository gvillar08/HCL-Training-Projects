package com.example.UserManager;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
		
	@Autowired
	private UserRepository ur;

    public Iterable<User> GetAllUsers()				//finds all of the users
    {
        return ur.findAll();
    }
    
    public int toInt(String id)						//converts inputed string to int
    {
		try {
			int conversion = Integer.parseInt(id);
			return conversion;
		}
		catch(NumberFormatException e) {
			return -1;								//return -1 on failure to convert
		}
    }
    
    int search = -1;
    
    public int getSearch() {						//getter for user's search
		return search;
	}

	public int setSearch(int search)				//setter for user's search
    {
    	return this.search = search;
    }
    
    public User GetUserById(int id)					//retrieves a user based on the inputed id
    {  	
		try {
			return ur.findById(id).get();
		}
		catch (NoSuchElementException e) {
			return null;							//return null on failure to find
		}	
    }
    
    public void editName(String entry, int id)		//edit a Name at the inputed id location to the string entry
    {
		User user = ur.findById(id).get();
		user.setName(entry);
    	ur.save(user);
    }
    
    public void editUsername(String entry, int id)	//edit a Username at the inputed id location to the string entry
    {
		User user = ur.findById(id).get();
		user.setUsername(entry);
    	ur.save(user);
    }
    
    public void editPassword(String entry, int id)	//edit a Password at the inputed id location to the string entry
    {
		User user = ur.findById(id).get();
		user.setPassword(entry);
    	ur.save(user);
    }
}