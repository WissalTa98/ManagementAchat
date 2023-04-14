package com.esprit.examen.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProjectController {
    //add product by wissal
    private final IProduitService produitService;

	@GetMapping
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
	}


}
