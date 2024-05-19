package com.microservice.questionService.service;

import com.microservice.questionService.dao.questiondao;
import com.microservice.questionService.model.answers;
import com.microservice.questionService.model.question;
import com.microservice.questionService.model.questionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class questionService {

    @Autowired
    questiondao QuestionDao;


    public List<question> getAllQuestion() {
        return QuestionDao.findAll();
    }

    public List<question> getQuestiobByCategory(String category) {
        return QuestionDao.findByCategory(category);
    }


    public String addQuestion(question Question) {
        QuestionDao.save(Question);
        return "SUCCESS";
    }

    public List<Integer> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = QuestionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
        return questions;
    }

    public ResponseEntity<List<questionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<questionWrapper> wrappers = new ArrayList<>();
        List<question> questions = new ArrayList<>();

        for(Integer id : questionIds){
            questions.add(QuestionDao.findById(id).get());
        }

        for(question Question : questions){
            questionWrapper wrapper = new questionWrapper();
//            wrapper.se(question.getId());
            wrapper.setQuestionTitle(Question.getQuestionTitle());
            wrapper.setOption1(Question.getOption1());
            wrapper.setOption2(Question.getOption2());
            wrapper.setOption3(Question.getOption3());
            wrapper.setOption4(Question.getOption4());
            wrappers.add(wrapper);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<answers> responses) {


        int right = 0;

        for(answers response : responses){
            question Question = QuestionDao.findById(response.getId()).get();
            if(response.getResp().equals(Question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
