package com.microservice.quizMService.dao;

import com.microservice.quizMService.model.QuizQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<QuizQ,Integer> {
}
