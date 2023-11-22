package me.dio.santanderapinuvem.service;

import me.dio.santanderapinuvem.domain.model.User;

public interface IUserService {
	
	User findById(Long id);
	
	User create(User userToCreate);

}
