package com.sollers.cal.service.impl;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sollers.cal.domain.MyNumber;
import com.sollers.cal.persistence.MyNumberRepository;
import com.sollers.cal.service.MyNumberService;

@Service
public class MyNumberServiceImpl implements MyNumberService{
	
	@Autowired
	private MyNumberRepository myNumberRepository;

	@Override
	public MyNumber save(MyNumber number) {
		return myNumberRepository.save(number);
	}

	@Override
	public List<MyNumber> findAll() {
		return myNumberRepository.findAllByOrderByIdDesc();
	}

	@Override
	public Optional<MyNumber> findTop() {
		return myNumberRepository.findTopByOrderByIdDesc();
	}
	
	public Double add(Double a, Double b) {
		
		return a+b;
	}
	
	public Double subtraction(Double a,Double b)
	{
		return a-b;
	}

	public JSONObject converToJson(Double firstNumber,Double secondNumber, Double result,String sign)
	{
		JSONObject jo = new JSONObject();
		jo.put("firstNumber", firstNumber);
		jo.put("secondNumber", secondNumber);
		jo.put("result", result);
		jo.put("sign",sign);

		return jo;
	}


}
