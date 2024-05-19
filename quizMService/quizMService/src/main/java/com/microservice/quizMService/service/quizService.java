package com.microservice.quizMService.service;

import com.microservice.quizMService.dao.QuizDao;
import com.microservice.quizMService.feign.quizINterface;
import com.microservice.quizMService.model.QuizQ;
import com.microservice.quizMService.model.answers;
import com.microservice.quizMService.model.questionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    quizINterface quizinterface;
    public String createQuiz(Integer num, String category, String title) {

        List<Integer> questions =quizinterface.getQuestionsForQuiz(category,num);
        QuizQ quizq=new QuizQ();
        quizq.setTitle(title);
        quizq.setQuestions(questions);
        quizDao.save(quizq);
        return "DONE CREATE";
    }

    public List<questionWrapper> getQuestion(Integer quizid) {
        QuizQ quizQuestions=quizDao.findById(quizid).get();
        List<Integer> questionIds=quizQuestions.getQuestions();
        List<questionWrapper> questionsfromwrapper=quizinterface.getQuestionsFromId(questionIds);
        return questionsfromwrapper;
    }

    public Integer calcScore(Integer quizId,List<answers> Answers) {

        return quizinterface.getScore(Answers);
    }
}
