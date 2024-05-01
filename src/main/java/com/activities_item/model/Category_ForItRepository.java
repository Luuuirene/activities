package com.activities_item.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface Category_ForItRepository extends JpaRepository<CategoryVO_ForIt, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "delete from activity_category where activity_category_id = ?1", nativeQuery = true)
	void deleteByActivityCategoryId(int activityCategoryId);

}
