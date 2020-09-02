package com.example.poklonsavjet;

import java.util.List;

public class QuestionWithAnswers {
    private String question;
    private List<String> answers;

    public QuestionWithAnswers(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
