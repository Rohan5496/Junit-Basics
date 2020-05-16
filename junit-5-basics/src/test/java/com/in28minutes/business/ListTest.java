package com.in28minutes.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListTest {

	@Test
	public void testMockListSizeMethod() {
		List listMock = mock(List.class);
		
		when(listMock.size())
							 .thenReturn(2)
							 .thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		
	}
	
	@Test
	public void testMockListGet() {
		List listMock = mock(List.class);
		
		when(listMock.get(anyInt()))
									.thenReturn("Same Value being returned due to Argument Mathchers");
		
		assertEquals("Same Value being returned due to Argument Mathchers", listMock.get(0));
		assertEquals("Same Value being returned due to Argument Mathchers", listMock.get(1));
		assertEquals("Same Value being returned due to Argument Mathchers", listMock.get(2));
	}
	
	@Test()
	public void testMockList_throwException() {
		List listMock = mock(List.class);
		
		when(listMock.get(anyInt()))
									.thenThrow(new RuntimeException("Something Bad occured"));
		
		assertThrows(RuntimeException.class, ()->listMock.get(0));
	}

}
