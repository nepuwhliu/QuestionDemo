package com.example.application.mvp.main.bean;

public class Question {
    private Integer id;

    private Integer questionLevelId;

    private Integer questionTypeId;

    private String answer;

    private Integer questionDifficultId;

    private String picture;

    private String knowledgeCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionLevelId() {
        return questionLevelId;
    }

    public void setQuestionLevelId(Integer questionLevelId) {
        this.questionLevelId = questionLevelId;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getQuestionDifficultId() {
        return questionDifficultId;
    }

    public void setQuestionDifficultId(Integer questionDifficultId) {
        this.questionDifficultId = questionDifficultId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getKnowledgeCode() {
        return knowledgeCode;
    }

    public void setKnowledgeCode(String knowledgeCode) {
        this.knowledgeCode = knowledgeCode == null ? null : knowledgeCode.trim();
    }
}