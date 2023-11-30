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

    public List<Question> deleteQuestionByCategory(String category) {
        return questionDao.deleteByCategory(category);
    }

    public Question changeQuestionToDB(Question question , int id) {
        System.out.println(question);
        Question que = questionDao.findById(id).get();
        que.setCategory(question.getCategory());
        que.setDifficultylevel(question.getDifficultylevel());
        que.setOption1(question.getOption1());
        que.setOption2(question.getOption2());

        questionDao.save(que);
        return que;
    }
}


//id - can't be null instead of default