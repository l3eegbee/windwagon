package com.windwagon.broceliande.race.repositories;

import android.annotation.*;

import com.windwagon.broceliande.race.entities.*;
import org.springframework.data.repository.*;

import java.util.*;

@SuppressLint("NewApi")
public interface RaceRepository extends CrudRepository<Race, Long> {
    List<Race> findByStatus( RaceStatus status );
    Race findByMeetingAndNumber( Meeting meeting, Integer number );

	default Race findOne(Long raceId) {
		return (Race) findById(raceId).orElse(null);
	}
}
//https://stackoverflow.com/a/51643180/2730847
//@NoRepositoryBean
//public interface BaseJpaRepository<T, ID> extends JpaRepository<T, ID> {
//	default T findOne(ID id) {
//		return (T) findById(id).orElse(null);
//	}
//}
