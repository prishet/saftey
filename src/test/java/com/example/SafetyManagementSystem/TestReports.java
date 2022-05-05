package com.example.SafetyManagementSystem;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.model.Reports;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.ReportsService;

@SpringBootTest
public class TestReports {
	@Autowired
	ReportsService service;
	
	@Test
	void testGetReport() {
		
		Reports reports = new Reports();
		
		reports.setPersonName("Arjun");
		reports.setIncidentName("Car Accident");	
		reports.setJobDescription("Cleark");
		reports.setUserReport("Complete");
		reports.setReportStartDate("01-01-2000");
		reports.setReportEndtDate("11-03-2000");
		service.addReports(reports);
		
		Reports repot_to_be_added = service.findReports(reports.getReportId());
		
		Assert.assertEquals("Arjun", repot_to_be_added.getPersonName());
		Assert.assertEquals("Car Accident", repot_to_be_added.getIncidentName());	
		Assert.assertEquals("Cleark", repot_to_be_added.getJobDescription());
		Assert.assertEquals("Complete", repot_to_be_added.getUserReport());
		Assert.assertEquals("01-01-2000", repot_to_be_added.getReportStartDate());
		Assert.assertEquals("11-03-2000", repot_to_be_added.getReportEndtDate());
	
	}
	

	@Test
	void testFindReport() {
		Reports reports = new Reports();
		reports.setPersonName("Arjun");
		try {
			service.addReports(reports);
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		Reports reports2=service.findReports(reports.getReportId());
		Assert.assertNotNull(reports2);
	}
	
	
	
	@Test
	void testFindAllReport() {
		
		Reports reports = new Reports();
		//reports.setPersonName("Arjun");
		reports.setIncidentName("Car Accident");	
		reports.setJobDescription("Cleark");
		reports.setUserReport("Complete");
		reports.setReportStartDate("01-01-2000");
		reports.setReportEndtDate("11-03-2000");
		service.addReports(reports);
		
		Reports reports1 = new Reports();
		//reports1.setPersonName("priya");
		reports1.setIncidentName("overexertion");	
		reports1.setJobDescription("teacher");
		reports1.setUserReport("Completed");
		reports1.setReportStartDate("02-02-2000");
		reports1.setReportEndtDate("22-03-2000");
		service.addReports(reports1);
		
		List<Reports> reportslist=service.findAllReports();
		reportslist.get(0).getIncidentName();
		Assert.assertEquals(reportslist.get(0).getIncidentName(), "Car Accident");
		Assert.assertEquals(reportslist.get(1).getIncidentName(), "overexertion");
		
		
	}
	@Test
	void testUpdateReports() {
		Reports reports = new Reports();
		reports.setPersonName("Arjun");
		reports.setIncidentName("Car Accident");	
		reports.setJobDescription("Cleark");
		reports.setUserReport("Complete");
		reports.setReportStartDate("01-01-2000");
		reports.setReportEndtDate("11-03-2000");
		service.addReports(reports);
		Assert.assertEquals(true, service.updateReports(reports));
		
	}

	@Test
	void testDeleteReports() {
		
		Reports reports = new Reports();
		reports.setPersonName("Arjun");
		reports.setIncidentName("Car Accident");	
		reports.setJobDescription("Cleark");
		reports.setUserReport("Complete");
		reports.setReportStartDate("01-01-2000");
		reports.setReportEndtDate("11-03-2000");
		service.addReports(reports);
		
		service.deleteReports(1);
		Reports deleteReports = service.findReports(1);
		Assert.assertNull(deleteReports);
	}
}
