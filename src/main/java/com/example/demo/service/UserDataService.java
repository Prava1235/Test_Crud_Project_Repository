package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking.RemoveCommand;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.UserData;

@Service
public class UserDataService {

	private List<UserData> userDatas = new ArrayList<>(Arrays.asList(new UserData(1, "Java1", "ADMIN"),
			new UserData(2, "Java2", "USER"), new UserData(3, "Java3", "ADMIN"), new UserData(4, "Java4", "USER"),
			new UserData(5, "Java5", "ADMIN"), new UserData(6, "Java6", "USER"), new UserData(7, "Java7", "ADMIN")));
	
	
	public List<UserData> getAllUserDatas() {
				return userDatas;
	}
	
	 public UserData getUserDataById(Integer id)  {
		
		return userDatas.stream().filter(t->t.getUserId().equals(id)).findFirst().get();

	} 
	 public void addUserData(UserData userData) {

			 userDatas.add(userData);
		}
	 public void deleteUserData(Integer id) {
		 userDatas.removeIf(t->t.getUserId().equals(id));
		 
	 }

		public void updateUserData(Integer id, UserData userData) {
			for(int i=0;i<userDatas.size();i++) {
				UserData t=userDatas.get(i);
				if(t.getUserId().equals(id)) {
					userDatas.set(i, userData);
					return;
				}
			}
		}
}
