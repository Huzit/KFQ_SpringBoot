package com.ggoreb.practice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.springframework.objenesis.instantiator.android.AndroidSerializationInstantiator;

@Data
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String subject;
	String content;

	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	User user;

	@OneToMany(mappedBy = "question")
	List<Answer> answerList;
}
