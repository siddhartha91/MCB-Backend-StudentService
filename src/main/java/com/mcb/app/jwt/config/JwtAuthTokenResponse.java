package com.mcb.app.jwt.config;

import lombok.Data;

@Data
public class JwtAuthTokenResponse {
	private String token;

	public JwtAuthTokenResponse(String token) {
		super();
		this.token = token;
	}
	
	
	
}
