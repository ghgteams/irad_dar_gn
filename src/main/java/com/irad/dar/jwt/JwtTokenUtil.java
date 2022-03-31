package com.irad.dar.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.irad.dar.master.UserDao;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 60 * 60 * 60 *24 *365;

	@Value("${jwt.secret}")
	private String secret;

	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
    //for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	//generate token for user
	public String generateToken(UserDetails userDetails,UserDao user) {
		System.out.println("GenerateToken");
		Map<String, Object> claims = new HashMap<>();
		claims.put("iss", "gisnic.tn.nic.in");
		claims.put("aud", "rta");
		return doGenerateToken(claims, userDetails.getUsername(),user);
	}

	//while creating the token -
	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	//   compaction of the JWT to a URL-safe string 
	@SuppressWarnings("unchecked")
	private String doGenerateToken(Map<String, Object> claims, String subject,UserDao user1) {
		JSONObject jOBj = new JSONObject();
		jOBj.put("id", user1.getId());
		jOBj.put("name", user1.getName());
		jOBj.put("username", user1.getUsername());
		jOBj.put("password", user1.getPassword());
		jOBj.put("role_code", user1.getRole_code());
		jOBj.put("dept", user1.getDept());
		jOBj.put("password_enc", user1.getPassword_enc());
		jOBj.put("mobile", user1.getMobile());
		jOBj.put("state_code", user1.getState_code());
		jOBj.put("district_code", user1.getDistrict_code());
		jOBj.put("station_code", user1.getStation_code());
		jOBj.put("email", user1.getEmail());
		jOBj.put("created_date", user1.getCreated_date());
//		jOBj.put("active", user1.get);
		
		
		System.out.println("doGenerateToken");
		return Jwts.builder().setClaims(claims).claim("data", jOBj).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	//validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		System.out.println("ValidateToken");
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}