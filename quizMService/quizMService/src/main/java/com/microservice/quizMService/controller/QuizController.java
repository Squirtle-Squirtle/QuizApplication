package com.microservice.quizMService.controller;

import com.microservice.quizMService.model.QuizDto;
import com.microservice.quizMService.model.answers;
import com.microservice.quizMService.model.questionWrapper;
import com.microservice.quizMService.service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    quizService quizservice;

    @PostMapping("createQuiz")
    public String createQuiz(@RequestBody QuizDto quizDto)
    {
        return quizservice.createQuiz(quizDto.getNum(),quizDto.getCategoryName(),quizDto.getTitle());
    }

    @GetMapping("get/{quizid}")
    public List<questionWrapper> get(@PathVariable Integer quizid)
    {

        return quizservice.getQuestion(quizid);
    }

    @PostMapping("submit/{quizId}")
    public Integer getScore(@PathVariable Integer quizId,@RequestBody List<answers> Answers)
    {
        return quizservice.calcScore(quizId,Answers);
    }

}
