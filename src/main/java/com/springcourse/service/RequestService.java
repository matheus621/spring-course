package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRespository;

@Service
public class RequestService {
	@Autowired private RequestRespository requestRespository;
	
	public Request save(Request request) {
		request.setState(RequestState.OPEN);
		request.setCreationDate(new Date());
		
		Request createdRequest = requestRespository.save(request);
		
		return createdRequest;
	}
	
	public Request update(Request request) {
		Request updateRequest = requestRespository.save(request);
		return updateRequest;
	}
	
	public Request getById(Long id) {
		Optional<Request> result = requestRespository.findById(id);
		return result.get();
	}
	
	public List<Request> listAll(){
		List<Request> requests = requestRespository.findAll();
		return requests;
	}
	
	public List<Request> listAllByOwnerId(Long ownerId){
		List<Request> requests = requestRespository.findAllByOwnerId(ownerId);
		return requests;
	}
	
}
