package org.gsc.medha.repository;

import java.util.List;

import org.gsc.medha.entity.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue, Integer> {
	@Query("SELECT s FROM Venue s WHERE s.name=?1 ")
	public List<Object> findByVenueName(String name);
	
}
