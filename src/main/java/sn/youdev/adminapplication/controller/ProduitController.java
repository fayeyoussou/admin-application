package sn.youdev.adminapplication.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.youdev.adminapplication.dto.request.ProduitRequest;
import sn.youdev.adminapplication.dto.response.ProduitResp;
import sn.youdev.adminapplication.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {
    private final ProduitService produitService;
    @GetMapping
    public List<ProduitResp> listProduits(){
        return produitService.getProduits();
    }
    @GetMapping("{id}")
    public ProduitResp findOneProduit(@PathVariable("id") final int id){
        return produitService.getProduitById(id);
    }
    @PostMapping
    public ProduitResp createProduit(@RequestBody final ProduitRequest request){
        return produitService.createProduit(request);
    }
    @PutMapping("{id}")
    public ProduitResp updateProduit(@PathVariable("id") final int id,@RequestBody final ProduitRequest request){
        return produitService.updateProduits(id,request);
    }
    @DeleteMapping("{id}")
    public void deleteProduit(@PathVariable("id") final int id){
         produitService.deleteProduit(id);
    }
}
