package com.activities_item.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ItemRepository extends JpaRepository<ItemVO, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "delete from activity_item where activity_id = ?1", nativeQuery = true)
	void deleteByActivityId(int activityId);

}
