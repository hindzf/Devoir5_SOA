package com.hind.stars.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hind.stars.entities.Star;
import com.hind.stars.entities.Type;

@RepositoryRestResource(path = "rest")
public interface StarRepository extends JpaRepository<Star, Long> {
	List<Star> findByNameStar(String nom);
	List<Star> findByNameStarContains(String nom);
	
	@Query("select s from Star s where s.nameStar like %?1 and s.age > ?2")
	List<Star> findByNameAge (@Param("name") String nom, @Param("age") Double age);
	
	@Query("select p from Star p where p.type = ?1")
	List<Star> findByType (Type type);
	
	List<Star> findByTypeIdType(Long id);
	
	List<Star> findByOrderByNameStarAsc();
	
	@Query("select s from Star s order by s.nameStar ASC, s.age DESC")
	List<Star> trierStarNameAge ();
	
}
