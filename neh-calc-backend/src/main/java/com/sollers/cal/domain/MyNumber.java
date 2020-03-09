package com.sollers.cal.domain;

import javax.persistence.*;


@Entity
public class MyNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name="firstNumber")
	Double firstNumber;

	@Column(name="secondNumber")
	Double secondNumber;

	@Column(name="result")
	Double result;

	String sign;
	
	public MyNumber()
	{
		
	}
	
	public MyNumber(Integer id, Double firstNumber, Double secondNumber, Double result) {
		super();
		this.id = id;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
	}

	
	public Double getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(Double firstNumber) {
		this.firstNumber = firstNumber;
	}
	public Double getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(Double secondNumber) {
		this.secondNumber = secondNumber;
	}
	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	

}
