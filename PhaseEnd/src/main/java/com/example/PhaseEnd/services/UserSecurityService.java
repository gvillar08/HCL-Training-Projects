//package com.example.PhaseEnd.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//import com.example.PhaseEnd.entities.User;
//import com.example.PhaseEnd.entities.UserSecurityPrincipal;
//import com.example.PhaseEnd.repositories.UserRepository;
//
//@Service
//public class UserSecurityService implements UserDetailsService
//{
//	@Autowired
//	private UserRepository ur;
//	
//	@Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = ur.findByUser(username);
////        if (user == null) {
////            throw new UsernameNotFoundException(username);		//HAVE THE CONTROLLER HANDLE THIS AS WELL AS SEARCHING ABOVE
////        }
//        System.out.println("whoa how did this load");
//        if(user == null)
//        	return null;
//        System.out.println("you are here");
//
//        return new UserSecurityPrincipal(user);
//    }
//	
////	@Bean
////	@Override
////	public UserDetailsService userDetailsService()						//sets a hard-coded in-memory user
////	{
////		UserDetails user =
////			User.withDefaultPasswordEncoder()
////				.username("user")										//set username to user
////				.password("pass")										//set password to pass
////				.roles("USER")
////				.build();
////
////		return new InMemoryUserDetailsManager(user);
////	}
//	
////	public Iterable<User> GetAllUsers() {	//finds all feedback
////		return ur.findAll();
////	}
//	
////	public Feedback saveFeedback(String user, Integer rating, String comments)	//saves feedback entries to the database
////	{
////		Feedback f = new Feedback();
////		f.setUser(user);
////		f.setRating(rating);
////		f.setComments(comments);
////		fr.save(f);
////		return f;
////	}
//}