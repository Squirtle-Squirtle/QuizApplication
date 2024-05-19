package com.microservice.quizMService.feign;

import com.microservice.quizMService.model.answers;
import com.microservice.quizMService.model.questionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONSERVICE")
public interface quizINterface {

    @GetMapping("question/generate")
    public List<Integer> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions );

    @PostMapping("question/getQuestions")
    public List<questionWrapper> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public Integer getScore(@RequestBody List<answers> responses);


}
