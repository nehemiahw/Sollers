package com.sollers.cal.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;

import com.sollers.cal.domain.MyNumber;

public interface MyNumberService {

	public MyNumber save (MyNumber number);

	
	public List<MyNumber> findAll();

	
	public Optional<MyNumber> findTop();

	public Double add(Double firstNumber,Double secondNumber);

	public Double subtraction(Double a,Double b);

	public JSONObject converToJson(Double firstNumber,Double secondNumber, Double result,String sign);

}
