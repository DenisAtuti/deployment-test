package com.atutidennis.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atutidennis.model.Booking;
import com.atutidennis.repository.BookingRepository;


@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public void saveOrder(Booking booking) {
		bookingRepository.save(booking);
	}
	
	public int getAnnualEarning() {
		List<Booking> bookingList = bookingRepository.findAll();
		ArrayList<Integer> hoursArray = new ArrayList<Integer>();
				
		bookingList.forEach(data -> {
			LocalDate currentDate = LocalDate.now(); // 2016-06-17
			int y = currentDate.getYear(); // 2016

			
			String bookingDate = data.getCleaningDate();
			LocalDate date = LocalDate.parse(bookingDate);
			
			int bookingYear = date.getYear();
			
			if(bookingYear == y) {
				hoursArray.add(Integer.parseInt(data.getHours()));
				
			}
			
		});
		
		int hours = 0;
		for (int i = 0; i < hoursArray.size(); i++) {
			hours = hours + hoursArray.get(i) ;
		}

		int totalHours = 25 * hours;
		return totalHours;
		
	}
	public int getMonthyEarning() {
		List<Booking> bookingList = bookingRepository.findAll();
		ArrayList<Integer> hoursArray = new ArrayList<Integer>();
				
		bookingList.forEach(data -> {
			LocalDate currentDate = LocalDate.now(); // 2016-06-17
			int mon = currentDate.getMonthValue();

			
			String bookingDate = data.getCleaningDate();
			LocalDate date = LocalDate.parse(bookingDate);
			
			int bookingMonth = date.getMonthValue();			
			if(bookingMonth == mon) {
				hoursArray.add(Integer.parseInt(data.getHours()));
			}
		});
		
		int hours = 0;
		for (int i = 0; i < hoursArray.size(); i++) {
			hours = hours + hoursArray.get(i) ;
		}	
		int totalHours = 25 * hours;
		
		return totalHours;
		
	}
	public long getEntries() {
		return bookingRepository.count();
		
	}
	
	public int getTodayTasks() {
		List<Booking> bookingList = bookingRepository.findAll();
		ArrayList<Integer> todayTask = new ArrayList<Integer>();
		bookingList.forEach(data -> {
			LocalDate currentDate = LocalDate.now();
			int todayDate = currentDate.getDayOfMonth();
			
			String bookingDate = data.getCleaningDate();
			LocalDate date = LocalDate.parse(bookingDate);
			int bookingDay = date.getDayOfMonth();
			
			if(todayDate == bookingDay) {
				todayTask.add(data.getId());
			}
			
		});
		
		return todayTask.size();
		
	}
	


}
