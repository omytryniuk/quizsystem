package ca.myseneca.a2;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	private int questionId;
	private String text;
	private String answerExplained;
	private String type;
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", text=" + text + ", answerExplained=" + answerExplained
				+ ", type=" + type + ", difficulty=" + difficulty + ", answers=" + answers + "]";
	}
	private int difficulty;
	private Set<Answer> answers = new HashSet<Answer>(0);
	
	public Question(){}
	public Question(String t,String ae, String type, int diff){
		this.text=t;
		this.answerExplained=ae;
		this.type=type;
		this.difficulty=diff;
	}
	public Question(int id, String t,String ae, String type, int diff){
		this.questionId=id;
		this.text=t;
		this.answerExplained=ae;
		this.type=type;
		this.difficulty=diff;
	}
	public Question(String t,String ae, String type, int diff,Set<Answer> ans){
		this.text=t;
		this.answerExplained=ae;
		this.type=type;
		this.difficulty=diff;
		this.answers=ans;
	}
	
	@Id
	@GeneratedValue
	public int getQuestionId() {
		return questionId;
	}
	
	
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAnswerExplained() {
		return answerExplained;
	}
	public void setAnswerExplained(String answerExplained) {
		this.answerExplained = answerExplained;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="question",orphanRemoval=true)
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	

}
