package com.windwagon.broceliande.race.repositories;

import com.windwagon.broceliande.*;
import com.windwagon.broceliande.race.builders.*;
import com.windwagon.broceliande.race.entities.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

import javax.transaction.*;

import static com.shazam.shazamcrest.matcher.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

//import org.springframework.boot.test.context.*;
//import static org.hamcrest.EasyMock2Matchers.equalTo;

//@RunWith(SpringJUnit4ClassRunner.class) //v1
@RunWith( /*SpringJUnit4Class*/SpringRunner.class ) //v2
@SpringBootTest(classes = Broceliande.class) //v2
//@SpringApplicationConfiguration(classes = Broceliande.class) //v1
public class RepoTest {

	@Autowired
	private MeetingRepository meetingRepository;

	@Test
	@Transactional
	public void saveTest() {

		Meeting saved = Meeting_20150813_M1.build();
		meetingRepository.save(saved);

		Meeting found = meetingRepository.findByDateAndNumber(saved.getDate(), saved.getNumber());

		assertThat(found, is(sameBeanAs(Meeting_20150813_M1.build()).ignoring(equalTo("id"))));

	}

}
