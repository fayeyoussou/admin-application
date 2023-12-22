package sn.youdev.adminapplication.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.youdev.adminapplication.dao.ProduitRepository;
import sn.youdev.adminapplication.dto.request.ProduitRequest;
import sn.youdev.adminapplication.dto.response.ProduitResp;
import sn.youdev.adminapplication.exception.EntityNotFoundException;
import sn.youdev.adminapplication.exception.RequestException;
import sn.youdev.adminapplication.mapper.ProduitMapper;

import java.util.List;
import java.util.Locale;


@Service
public class ProduitService {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;
    private final MessageSource messageSource;

    public ProduitService(ProduitRepository produitRepository, ProduitMapper produitMapper, MessageSource messageSource) {
        this.produitRepository = produitRepository;
        this.produitMapper = produitMapper;
        this.messageSource = messageSource;
    }
    @Transactional(readOnly = true)
    public List<ProduitResp> getProduits() {
        return produitRepository.findAll().stream()
                .map(produitMapper::fromProduit)
                .toList();
    }
    @Transactional(readOnly = true)
    public ProduitResp getProduitById(int id) {
        return produitMapper.fromProduit(produitRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("produit.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }
    @Transactional
    public ProduitResp createProduit(ProduitRequest request) {
        return produitMapper.fromProduit(produitRepository.save(produitMapper.toProduit(request)));
    }
    @Transactional
    public ProduitResp updateProduits(int id, ProduitRequest request) {
        return produitRepository.findById(id)
                .map(entity ->  produitMapper.fromProduit(
                            produitRepository.save(produitMapper.toProduit(request)))).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("produit.notfound", new Object[]{id},
                        Locale.getDefault())));
    }
    @Transactional
    public void deleteProduit(int id) {
        try {
            produitRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("produit.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
