package com.example.demo.controller;

import com.example.demo.Question;
import com.example.demo.service.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionServices questionServices;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
     return questionServices.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
      return questionServices.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionServices.addQuestionToDB(question);
    }
}
