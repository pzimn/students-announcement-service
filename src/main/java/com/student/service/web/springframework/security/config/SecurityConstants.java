package com.student.service.web.springframework.security.config;

public class SecurityConstants {

	public static final String SECRET = "Announcement-portal";
	public static final long EXPIRATION_TIME = 860_400_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/login";
}
