package ca.myseneca.a2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Answer {
	private Integer answerId;
	private String text;
	private String correct;
	private Question question;
	
	public Answer(){}
	public Answer(Question question,String text, String correct){
		this.text=text;
		this.question=question;
		this.correct=correct;
	}
	@Id
	@GeneratedValue
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//@Type(type="yes_no")
	public String isCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="questionId",nullable=false)
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
