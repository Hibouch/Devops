package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Reglement;

import java.util.Date;
import java.util.List;

public interface IReglementService {

	List<Reglement> retrieveAllReglements();
	Reglement addReglement(Reglement r);
	Reglement retrieveReglement(Long id);
	void deleteReglement(Long id);
	Reglement updateReglement(Reglement r);
	List<Reglement> retrieveReglementByFacture(Long idFacture);
	float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate); 

}
