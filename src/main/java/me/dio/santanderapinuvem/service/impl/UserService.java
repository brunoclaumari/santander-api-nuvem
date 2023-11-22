package me.dio.santanderapinuvem.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me.dio.santanderapinuvem.domain.model.User;
import me.dio.santanderapinuvem.repository.UserRepository;
import me.dio.santanderapinuvem.service.IUserService;

@Service
public class UserService implements IUserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {		
		
		return userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Entity not found"));
	}

	@Override
	@Transactional
	public User create(User userToCreate) {
		if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This Account number already exists.");
		}		
		
		return userRepository.save(userToCreate);
	}

}
