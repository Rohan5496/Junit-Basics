package com.in28minutes.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {
	
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> retrieveTodosRelatedToSpring = todoBusinessImpl.
				retrieveTodosRelatedToSpring("Dummy");
		assertEquals(3, retrieveTodosRelatedToSpring.size(),()->"should return 3 as size");
		
	}

}
