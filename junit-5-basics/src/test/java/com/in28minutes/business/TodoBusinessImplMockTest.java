package com.in28minutes.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.in28minutes.data.api.TodoService;


public class TodoBusinessImplMockTest {
	
	// What is Mocking ??
	// Mocking is creating objects that simulate the behavior of real objects.
	// Unlike stubs , mocks can be dynamically created from code -- at runtime.
	// Mocks offer more functionality than stubs.
	// Method calls can be verified and a lot of 
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		TodoService todoServiceMock= mock(TodoService.class);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		when(todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC","Learn Spring Boot","Learn Spring Data-Jpa"));
		
		List<String> retrieveTodosRelatedToSpring = todoBusinessImpl.
				retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(3, retrieveTodosRelatedToSpring.size(),()->"should return 3 as size");
		
	}

}
