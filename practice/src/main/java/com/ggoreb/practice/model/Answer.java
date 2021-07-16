package com.ggoreb.practice.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String content;
	Date createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	Question question;
}
