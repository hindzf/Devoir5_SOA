package com.hind.stars.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hind.stars.entities.Star;
import com.hind.stars.entities.Type;

public interface StarService {
	Star saveStar(Star s);
	Star updateStar(Star s);
	void deleteStar(Star s);
	void deleteStarById(Long id);
	Star getStar(Long id);
	List<Star> getAllStars();
	Page<Star> getAllStarsParPage(int page, int size);
	List<Star> findByNameStar(String nom);
	List<Star> findByNameStarContains(String nom);
	List<Star> findByNameAge (String nom, Double age);
	List<Star> findByType (Type type);
	List<Star> findByTypeIdType(Long id);
	List<Star> findByOrderByNameStarAsc();
	List<Star> trierStarNameAge();
}
