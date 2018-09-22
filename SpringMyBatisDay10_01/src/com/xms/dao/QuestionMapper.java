package com.xms.dao;

import java.util.List;

import com.xms.entity.MyAnnotation;
import com.xms.entity.Question;

@MyAnnotation
public interface QuestionMapper {
	List<Question> findAll();
}
