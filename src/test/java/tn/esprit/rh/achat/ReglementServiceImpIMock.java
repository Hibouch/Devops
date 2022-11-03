package tn.esprit.rh.achat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes=AchatApplication.class)
@ExtendWith(MockitoExtension.class)
public class ReglementServiceImpIMock {
	@Mock
    ReglementRepository reglementRepository;
    @InjectMocks
    ReglementServiceImpl reglementService;
    
    
   
    Reglement regl1 = new Reglement(1.5f, 1.5f,Boolean.TRUE, new Date());
   
    List<Reglement> listReglement = new ArrayList<Reglement>() {
        {
            add(new Reglement(2.5f, 2.5f,Boolean.TRUE, new Date()));
            add(new Reglement(3.5f, 3.5f,Boolean.FALSE, new Date()));
        }
    };

    @Test
    void retrieveReglement() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(regl1));
        Reglement reg1 = reglementService.retrieveReglement(0L);
        Assertions.assertNotNull(reg1);
    }
    
    
    @Test
    void addReglement() {
    	Reglement regl2 = new Reglement(4.5f, 4.5f,Boolean.TRUE, new Date());
        Mockito.when(reglementRepository.save(ArgumentMatchers.any(Reglement.class))).thenReturn(regl2);
        Reglement created = reglementService.addReglement(regl2);
        Assertions.assertSame(created,regl2);
        Mockito.verify(reglementRepository).save(regl2);
    }
}

