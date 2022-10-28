package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.*;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

	@Override
	public List<Facture> retrieveAllFactures() {
		
		return null;
	}

	@Override
	public List<Facture> getFacturesByFournisseur(Long idFournisseur) {

		return null;
	}

	@Override
	public Facture addFacture(Facture f) {
		
		return null;
	}

	@Override
	public void cancelFacture(Long id) {
		
		
	}

	@Override
	public Facture retrieveFacture(Long id) {

		return null;
	}

	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {

		//TO DO LATER
	}

	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {

		return 0;
	}

	
	

}