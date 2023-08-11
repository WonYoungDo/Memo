package com.tawny.memo.post.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
	
	private int id;
	private int userId;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private Date createdAT;
	private Date updatedAT;
}
