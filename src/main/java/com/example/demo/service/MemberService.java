package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberTO;

@Service
public interface MemberService extends UserDetailsService {
	Integer save(MemberTO memberTO); 
}
