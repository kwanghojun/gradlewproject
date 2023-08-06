package com.example.demo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.MemberTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        return new User("1234","1234", null);
    }

    @Transactional
    @Override
    public Integer save(MemberTO memberTO) {
    	Integer get=new Integer("10");
        return get;
    }
}
