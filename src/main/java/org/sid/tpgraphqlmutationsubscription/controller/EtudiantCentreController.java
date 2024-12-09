package org.sid.tpgraphqlmutationsubscription.controller;

import org.sid.tpgraphqlmutationsubscription.dto.EtudiantDTO;
import org.sid.tpgraphqlmutationsubscription.model.Centre;
import org.sid.tpgraphqlmutationsubscription.model.Etudiant;
import org.sid.tpgraphqlmutationsubscription.service.CentreService;
import org.sid.tpgraphqlmutationsubscription.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;


@Controller
public class EtudiantCentreController {
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    CentreService centreService;

    @QueryMapping
    public List<Centre> getAllCentres() {
        return centreService.centres();
    }

    @QueryMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getStudents();
    }

    @QueryMapping
    public Centre getCentre(@Argument Long id) {
        return centreService.getCentre(id);
    }

    @QueryMapping
    public Etudiant getEtudiant(@Argument Long id) {
        return etudiantService.getEtudiant(id);
    }

    @MutationMapping
    public Etudiant addEtudiant(@Argument EtudiantDTO etudiantDTO) {
        return etudiantService.addEtudiant(etudiantDTO);
    }

    @MutationMapping
    public String suppEtudiant(@Argument Long id) {
        return etudiantService.deleteEtudiant(id);
    }

    @MutationMapping
    public Etudiant updateEtudiant(@Argument Long id, @Argument EtudiantDTO etudiantDTO) {
        return etudiantService.updateEtudiant(id, etudiantDTO);
    }

    @SubscriptionMapping
    public Flux<Etudiant> etudiantAdded() {
        return etudiantService.getEtudiantAddedPublisher();
    }
}
