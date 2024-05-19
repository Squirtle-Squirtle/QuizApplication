package com.microservice.questionService.controller;

import com.microservice.questionService.model.answers;
import com.microservice.questionService.model.question;
import com.microservice.questionService.model.questionWrapper;
import com.microservice.questionService.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    questionService QuestionService;

    @GetMapping("allQuestion")
    public List<question> getAllQuestion()
    {
        return QuestionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<question> getQuestionByCategory(@PathVariable String category)
    {
        return QuestionService.getQuestiobByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody question Question)
    {

        return QuestionService.addQuestion(Question);
    }
    @GetMapping("generate")
    public List<Integer> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
        return QuestionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<questionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return QuestionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<answers> responses)
    {
        return QuestionService.getScore(responses);
    }

}
