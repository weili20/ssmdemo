package com.hpe.demo.ssm.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hpe.demo.ssm.BaseTest;
import com.hpe.demo.ssm.mapper.AppointmentMapper;
import com.hpe.demo.ssm.po.Appointment;

public class AppointmentDaoTest extends BaseTest {

	@Autowired
	private AppointmentMapper appointmentDao;

	@Test
	public void testInsertAppointment() throws Exception {
		long bookId = 1000;
		long studentId = 12345678910L;
		int insert = appointmentDao.insertAppointment(bookId, studentId);
		System.out.println("insert=" + insert);
	}

	@Test
	public void testQueryByKeyWithBook() throws Exception {
		long bookId = 1000;
		long studentId = 12345678910L;
		Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
		System.out.println(appointment);
		System.out.println(appointment.getBook());
	}

}
