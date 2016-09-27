package com.hpe.demo.ssm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hpe.demo.ssm.BaseTest;
import com.hpe.demo.ssm.dto.AppointExecution;
import com.hpe.demo.ssm.service.BookService;

public class BookServiceImplTest extends BaseTest {

	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception {
		long bookId = 1001;
		long studentId = 12345678910L;
		AppointExecution execution = bookService.appoint(bookId, studentId);
		System.out.println(execution);
	}

}
