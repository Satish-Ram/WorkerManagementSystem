package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AuthServiceImpl implements AuthService{
	
	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	public AuthServiceImpl(AdminRepository adminRepository,PasswordEncoder passwordEncoder,JwtUtil jwtUtil) {
		this.adminRepository=adminRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtUtil=jwtUtil;
	}

	@Override
	public String register(RegisterRequest request) {
		Admin admin=new Admin();
		
		admin.setName(request.getName());
		admin.setEmail(request.getEmail());
		admin.setPassword(passwordEncoder.encode(request.getPassword()));
		
		adminRepository.save(admin);
		return "Admin Registered Successfully";
	}

	@Override
	public String login(LoginRequest request) {
		Admin admin=adminRepository.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("Invalid Email"));
		if(!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
			throw new RuntimeException("Invalid Passoword");
		}
		return jwtUtil.generateToken(admin.getEmail());
	}

}
