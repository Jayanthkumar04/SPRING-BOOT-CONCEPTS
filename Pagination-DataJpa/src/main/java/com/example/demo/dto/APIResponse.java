package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class APIResponse<T> {

	int recoredCount;
	T response;
	
	public int getRecoredCount() {
		return recoredCount;
	}
	public void setRecoredCount(int recoredCount) {
		this.recoredCount = recoredCount;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public APIResponse(int recoredCount, T response) {
		super();
		this.recoredCount = recoredCount;
		this.response = response;
	}
	@Override
	public String toString() {
		return "APIResponse [recoredCount=" + recoredCount + ", response=" + response + "]";
	}
	
	
}
