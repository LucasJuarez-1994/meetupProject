package com.santander.meetup;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class TimeService {
	
private boolean testMode = false;
	
	private LocalDateTime nowForTesting = null;
	
	public void setNowForTesting(LocalDateTime nowForTesting) {
		this.nowForTesting = nowForTesting;
	}

	public TimeService() {
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime now() {
		if(isTestMode()) {
			if(nowForTesting==null) {
				throw new RuntimeException(TimeService.class.getName() + "  with testMode = true. But nowForTesting not setted ");
			}
			return nowForTesting;
		}else {
			return LocalDateTime.now();
		}
	}

	public LocalDateTime atStartDay() {

		return now().toLocalDate().atStartOfDay();
	}

	public LocalDateTime atEndDay() {

		return now().toLocalDate().atTime(23, 59, 59, 999999);
	}
	
	public LocalDateTime atEndDay(LocalDate date) {

		return date.atTime(23, 59, 59, 999999);
	}

	public boolean isTestMode() {
		return testMode;
	}

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}

}
