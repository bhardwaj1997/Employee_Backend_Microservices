package com.assessment.service;

import com.assessment.model.Questions;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

  public Questions saveQuestion(Questions question);
}
