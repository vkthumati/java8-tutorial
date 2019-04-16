package com.thumati.corejava.dateandtime;

import java.time.*;
import java.lang.reflect.*;

public class JodaDateAndTime {
	
	int a;
	int b;
	
	public JodaDateAndTime(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		int dd = date.getDayOfMonth();
		int mm = date.getMonthValue();
		int yyyy = date.getYear();
		System.out.println(mm+" - "+dd+" - "+yyyy);
		System.out.printf("%d - %d - %d",mm,dd,yyyy);
		
		System.out.println();
		LocalTime time = LocalTime.now();
		System.out.println(time);
		int hh = time.getHour();
		int min= time.getMinute();
		int sec = time.getSecond();
		int milsec = time.getNano();
		
		System.out.printf("%d:%d:%d.%d", hh,min,sec,milsec);
		
		System.out.println();
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		LocalDateTime dateTime1 = LocalDateTime.of(1995, 05 , 28, 12, 48);
		System.out.println(dateTime1);
		System.out.println("After six months : "+dateTime1.plusMonths(6));
		System.out.println("After six months : "+dateTime1.plusMonths(-6));
		System.out.println("Before six months : "+dateTime1.minusMonths(6));
		
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("Zone Id : "+zoneId);
		
		ZoneId la = ZoneId.of("America/Los_Angeles");
		System.out.println("Zone Id : "+la);
		
		ZonedDateTime now = ZonedDateTime.now(la);
		System.out.println(la+" current time : "+now);
		
	}

}
