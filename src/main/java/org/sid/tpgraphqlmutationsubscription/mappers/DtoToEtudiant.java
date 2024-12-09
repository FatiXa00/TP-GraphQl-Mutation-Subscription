package org.sid.tpgraphqlmutationsubscription.mappers;

import org.sid.tpgraphqlmutationsubscription.dto.EtudiantDTO;
import org.sid.tpgraphqlmutationsubscription.model.Centre;
import org.sid.tpgraphqlmutationsubscription.model.Etudiant;
import org.sid.tpgraphqlmutationsubscription.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToEtudiant {
    @Autowired
    CentreRepository centreRepository;

    public void toEtudiant(Etudiant et, EtudiantDTO dto) {
        Centre centre = centreRepository.findById(dto.centreId()).orElse(null);
        if (dto != null) {
            et.setNom(dto.nom());
            et.setPrenom(dto.prenom());
            et.setGenre(dto.genre());
            et.setCentre(centre);
        }
    }
}

