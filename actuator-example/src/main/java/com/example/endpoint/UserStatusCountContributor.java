package com.example.endpoint;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStatusCountContributor implements InfoContributor {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void contribute(Info.Builder builder) {
		Map<String, Long> userStatusMap = new HashMap<>();
		userStatusMap.put("active", userRepository.getUserStatusCountByStatus("active"));
		userStatusMap.put("inActive", userRepository.getUserStatusCountByStatus("inActive"));
		builder.withDetail("userStatus", userStatusMap);
	}
}