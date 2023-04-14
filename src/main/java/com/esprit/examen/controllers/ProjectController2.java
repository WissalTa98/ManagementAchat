package com.esprit.examen.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProjectController {
    private final IFactureService factureService;

    @GetMapping
    public List<Facture> getFactures() {
        return factureService.retrieveAllFactures();
    }


    @GetMapping("/{facture-id}")

    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }


    @PostMapping
    public Facture addFacture(@RequestBody Facture f) {
        Facture facture = factureService.addFacture(f);
        return facture;
    }

    /*
     * une facture peut etre annulé si elle a été saisie par erreur Pour ce
     * faire, il suffit de mettre le champs active à false
     */
    @PutMapping("/cancel/{facture-id}")
    public void cancelFacture(@PathVariable("facture-id") Long factureId) {
        factureService.cancelFacture(factureId);
    }

    @GetMapping("/byfournisseur/{fournisseur-id}")
    public List<Facture> getFactureByFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return factureService.getFacturesByFournisseur(fournisseurId);
    }

    @PutMapping(value = "/assign-to-operateur/{idOperateur}/{idFacture}")
    public void assignOperateurToFacture(@PathVariable("idOperateur") Long idOperateur, @PathVariable("idFacture") Long idFacture) {
        factureService.assignOperateurToFacture(idOperateur, idFacture);
    }

    @GetMapping(value = "/pourcentage-recouvrement/{startDate}/{endDate}")
    public float pourcentageRecouvrement(
            @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

        return factureService.pourcentageRecouvrement(startDate, endDate);

    }

}