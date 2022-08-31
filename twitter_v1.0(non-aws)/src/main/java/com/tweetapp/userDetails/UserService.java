package com.tweetapp.userDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean checkEmail(String email) {
		Users a = userRepository.findByemail(email);
		if(a==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String register(Users user) {
		{
			Users user1 = userRepository.findByuname(user.getUname());
			if(this.checkEmail(user.getEmail()))
			{
				if(user1==null)
				{
					userRepository.save(user);
					return "User registered";
				}
			}
			return "Username or Email already taken";
		}
		
	}
	
	
	
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Users getUser(String uname) {
		return userRepository.findByuname(uname);
	}
	
	public String updatePassword(String uname,Users user) {
		Users user1 = userRepository.findByuname(uname);
		
		if(user1==null)
		{
			return "No such user available";
		}
		else
		{
			userRepository.DeleteByuname(uname);
			Users updatedUser = userRepository.save(user);
			return "Password Updated";
		}
	}
	
	public List<Users> searchByRegex(String str){
		return userRepository.searchByRegex(str);
	}
	
	public String authenticate(String uname, String password) {
		Users user = userRepository.findByuname(uname);
		
		if(user==null)
			return "No such user";
		
		if(user.getPassword().equals(password)){
			return "Successfully Logged In";
		}
		else
			return "Invalid password";
	}

}
