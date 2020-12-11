package com.hind.stars.entities;

import org.springframework.data.rest.core.config.Projection;

public class ProduitProjection {
	
	@Projection(name = "nameStar", types = { Star.class })
	public interface StarProjection {
	public String getNameStar();
	}

}
