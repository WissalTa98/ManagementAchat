package com.esprit.examen.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProjectController {
    private final ICategorieProduitService categorieProduitService;
	
	@GetMapping
	public List<CategorieProduit> getCategorieProduit() {
		List<CategorieProduit> list = categorieProduitService.retrieveAllCategorieProduits();
		return list;
	}

	@GetMapping("/{categorieProduit-id}")
	public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
	}

	@PostMapping
	public CategorieProduit addCategorieProduit(@RequestBody CategorieProduit cp) {
		CategorieProduit categorieProduit = categorieProduitService.addCategorieProduit(cp);
		return categorieProduit;
	}

	@DeleteMapping("{categorieProduit-id}")
	public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		categorieProduitService.deleteCategorieProduit(categorieProduitId);
	}

	@PutMapping
	public CategorieProduit modifyCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
		return categorieProduitService.updateCategorieProduit(categorieProduit);
	}
}