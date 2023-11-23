package com.example.demo.service;
import com.example.demo.Question;
import com.example.demo.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class QuestionServices {

   @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions(){
       return questionDao.findAll();
    }
    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestionToDB(Question question) {
        questionDao.save(question);
        return "Success";
    }
}


//id - can't be null instead of default