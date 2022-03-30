package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> foundWhisky = whiskyRepository.findByYear(1991);
		assertEquals(1, foundWhisky.size());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Speyside");
		assertEquals(3, foundDistilleries.size());
	}

	@Test
	public void canFindWhiskyByDistilleryAndYear(){
//		Distillery sampleDistillery = new Distillery("happy place", "Glasgow");
//		Whisky testWhisky = new Whisky("test", 12, 1990, sampleDistillery);
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryNameAndAge("Rosebank", 12);
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void canFindWhiskiesByRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegion("Speyside");
		assertEquals(3, foundWhiskies.size());
	}

	@Test
	public void canFind12YearWhiskyDistilleries(){
		List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, foundDistilleries.size());
	}

}
