package com.hind.stars;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hind.stars.entities.Star;
import com.hind.stars.entities.Type;
import com.hind.stars.repos.StarRepository;
import com.hind.stars.service.StarService;

@SpringBootTest
class StarsApplicationTests {
	
	@Autowired
	private StarRepository starRepository;
	
	@Autowired
	StarService starService;

	@Test
	void testCreateStar() {
		Star star = new Star("Sirius",230,new Date());
		starRepository.save(star);
	}
	
	@Test
	public void testFindStar()
	{
		Star s = starRepository.findById(1L).get();
		System.out.println(s);
	}
	
	@Test
	public void testUpdateStar()
	{
		Star s = starRepository.findById(1L).get();
		s.setAge(300);
		starRepository.save(s);
	}
	
	@Test
	public void testDeleteStar() {
		starRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousStars()
	{
		List<Star> stars = starRepository.findAll();
		for (Star s : stars)
		{
			System.out.println(s);
		}
	}
	
	/*@Test
	public void testFindByNomStarContains()
	{
	Page<Star> stars = starService.getAllStarsParPage(0,2);
	System.out.println(stars.getSize());
	System.out.println(stars.getTotalElements());
	System.out.println(stars.getTotalPages());
	stars.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	
	@Test
	public void testFindByNomStarContains() {
		List<Star> stars=starRepository.findByNameStarContains("Bete");

		for (Star s : stars)
		{
		System.out.println(s);
		}
	}

	
	
	@Test 
	public void testFindByNomStar()
	{
		List<Star> stars = starRepository.findByNameStar("Betelgeuse");
		for (Star s : stars)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByNomAge()
	{
		List<Star> stars = starRepository.findByNameAge("Betelgeuse", (double)10);
		for (Star s : stars)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByType()
	{
		Type type = new Type();
		type.setIdType(1L);
		List<Star> stars = starRepository.findByType(type);
		for (Star s : stars)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void findByTypeIdType()
	{
		List<Star> stars = starRepository.findByTypeIdType(1L);
		for (Star s : stars)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void findByOrderByNomStarAsc()
	{
		List<Star> stars = starRepository.findByOrderByNameStarAsc();
		for (Star s : stars)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void trierStarNomAge()
	{
		List<Star> stars = starRepository.trierStarNameAge();
		for (Star s : stars)
		{
			System.out.println(s);
		}
	}
	
	
	
	
	
}
