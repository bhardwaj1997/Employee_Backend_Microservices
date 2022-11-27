package com.assessment.service.Impl;

import com.assessment.model.Questions;
import com.assessment.repository.QuestionRepository;
import com.assessment.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

  @Autowired
  private QuestionRepository questionRepository;


  @Override
  public Questions saveQuestion(Questions question) {
    return questionRepository.save(question);
  }
}
