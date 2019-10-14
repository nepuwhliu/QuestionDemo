package com.example.application.mvp.main.bean;

public class QuestionBean extends Question {
    private String questionContent;

    private String questionOne;

    private String questionTwo;

    private String questionThree;

    private String questionFour;

    private String questionFive;

    private String questionSix;

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne == null ? null : questionOne.trim();
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo == null ? null : questionTwo.trim();
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public void setQuestionThree(String questionThree) {
        this.questionThree = questionThree == null ? null : questionThree.trim();
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public void setQuestionFour(String questionFour) {
        this.questionFour = questionFour == null ? null : questionFour.trim();
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public void setQuestionFive(String questionFive) {
        this.questionFive = questionFive == null ? null : questionFive.trim();
    }

    public String getQuestionSix() {
        return questionSix;
    }

    public void setQuestionSix(String questionSix) {
        this.questionSix = questionSix == null ? null : questionSix.trim();
    }
}
