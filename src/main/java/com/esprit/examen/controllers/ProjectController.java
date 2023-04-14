package com.esprit.examen.controllers;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;

import java.util.List;

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

	@GetMapping("/{stock-id}")
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

    @GetMapping("/{produit-id}")
    public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
        return produitService.retrieveProduit(produitId);
    }

    /* Ajouter en produit tout en lui affectant la catégorie produit et le stock associés */
    @PostMapping
    public Produit addProduit(@RequestBody Produit p) {
        return produitService.addProduit(p);
    }

    @DeleteMapping("/{produit-id}")
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        produitService.deleteProduit(produitId);
    }

    @PutMapping
    public Produit modifyProduit(@RequestBody Produit p) {
        return produitService.updateProduit(p);
    }

    /*
     * Si le responsable magasin souhaite modifier le stock du produit il peut
     * le faire en l'affectant au stock en question
     */
    // http://localhost:8089/SpringMVC/produit/assignProduitToStock/1/5
    @PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
    public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
        produitService.assignProduitToStock(idProduit, idStock);
    }


}
