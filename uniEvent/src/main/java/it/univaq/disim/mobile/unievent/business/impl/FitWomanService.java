package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import it.univaq.disim.mobile.unievent.business.domain.SchedaPersonale;
import it.univaq.disim.mobile.unievent.business.domain.Utente;
import java.util.List;

public interface FitWomanService {

    List<Esercizio> findAllEsercizi();
    Esercizio findEsercizioById(Long id);
    List<Esercizio> findEsercizioByLivello(Long livello);
    List<Esercizio>findEserciziByLivelloAndZona(long livello, String zona);





    Utente findUtenteByUsername(String username);
    Utente updateProfilo(Utente utente);
    List<Scheda> findAllSchede();
    // List<Esercizio> findEsercizioById(long idEsercizio) throws BusinessException;
    void createScheda(SchedaPersonale scheda);
    void updateScheda(Scheda scheda) ;
    void deleteScheda(long idScheda);

}

