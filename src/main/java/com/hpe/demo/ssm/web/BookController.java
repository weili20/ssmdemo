package com.hpe.demo.ssm.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hpe.demo.ssm.dto.AppointExecution;
import com.hpe.demo.ssm.enums.AppointStateEnum;
import com.hpe.demo.ssm.exception.AppointException;
import com.hpe.demo.ssm.po.Book;
import com.hpe.demo.ssm.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model) {
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}
	
	@RequestMapping(value = "/{bookId}/appoint/add", method = RequestMethod.GET)
	private String appoint(@PathVariable("bookId") Long bookId, Model model) {
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		} else if(book.getNumber()<1) {
			model.addAttribute("appointExecution", new AppointExecution(bookId, AppointStateEnum.NO_NUMBER));
			return "appointResult";
		}
		model.addAttribute("book", book);
		return "apointadd";
	}

	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST)
	private String appoint(@PathVariable("bookId") Long bookId, @Param("studentId") Long studentId, Model model) {
		AppointExecution execution = null;
		try {
			execution = bookService.appoint(bookId, studentId);
		} catch(AppointException e) {
			execution = new AppointExecution(bookId, e.getState());
		}
		model.addAttribute("appointExecution", execution);
		return "appointResult";
	}

}
