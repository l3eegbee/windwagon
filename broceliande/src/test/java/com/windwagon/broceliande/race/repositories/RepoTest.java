package com.windwagon.broceliande.race.repositories;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.windwagon.broceliande.Broceliande;
import com.windwagon.broceliande.race.builders.Meeting_20150813_M1;
import com.windwagon.broceliande.race.entities.Meeting;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = Broceliande.class )
public class RepoTest {

    @Autowired
    private MeetingRepository meetingRepository;

    @Test
    @Transactional
    public void saveTest() {

        Meeting saved = Meeting_20150813_M1.build();
        meetingRepository.save( saved );

        Meeting found = meetingRepository.findByDateAndNumber( saved.getDate(), saved.getNumber() );

        assertThat(
                found,
                is( sameBeanAs( Meeting_20150813_M1.build() ).ignoring( equalTo( "id" ) ) ) );

    }

}
