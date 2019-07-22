package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTests {
	@Autowired private RequestRespository requestRespository;
	
	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request(null, "Novo Laptop HP", "Pretendo obter um laptop HP",new Date(), RequestState.OPEN, owner, null);
		
		Request createdRequest = requestRespository.save(request);
		
		assertThat(createdRequest.getId()).isEqualTo(1L);
	}
	
	@Test
	public void updateTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request(1L, "Novo Laptop HP", "Pretendo obter um laptop HP, de RAM 16 GB", null, RequestState.OPEN, owner, null);
		
		Request updateRequest = requestRespository.save(request);
		
		assertThat(updateRequest.getDescription()).isEqualTo("Pretendo obter um laptop HP, de RAM 16 GB");
	}
	
	@Test
	public void getByIdTest() {
		Optional<Request> result = requestRespository.findById(1L);
		Request request = result.get();
		
		assertThat(request.getSubject()).isEqualTo("Novo Laptop HP");
	}
	
	@Test
	public void listTest() {
		List<Request> requests = requestRespository.findAll();	
		
		assertThat(requests.size()).isEqualTo(1);
		
	}
	
	@Test
	public void listByOwnerIdTest() {
		List<Request> requests = requestRespository.findAllByOwnerId(1L);	
		
		assertThat(requests.size()).isEqualTo(1);
		
	}

	@Test
	public void updateStatusTest() {
		int affectedRows = requestRespository.updateStatus(1L, RequestState.IN_PROGRESS);
		
		assertThat(affectedRows).isEqualTo(1);
	}
	
}

