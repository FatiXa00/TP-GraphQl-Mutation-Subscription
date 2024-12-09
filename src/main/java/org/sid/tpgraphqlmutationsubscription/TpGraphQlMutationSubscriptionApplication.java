package org.sid.tpgraphqlmutationsubscription;

import org.sid.tpgraphqlmutationsubscription.enums.Genre;
import org.sid.tpgraphqlmutationsubscription.model.Centre;
import org.sid.tpgraphqlmutationsubscription.model.Etudiant;
import org.sid.tpgraphqlmutationsubscription.repository.CentreRepository;
import org.sid.tpgraphqlmutationsubscription.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpGraphQlMutationSubscriptionApplication implements CommandLineRunner {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CentreRepository centreRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpGraphQlMutationSubscriptionApplication.class, args);
    }

    public TpGraphQlMutationSubscriptionApplication(EtudiantRepository etudiantRepository, CentreRepository centreRepository) {
        this.etudiantRepository = etudiantRepository;
        this.centreRepository = centreRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Centre centre1 = Centre.builder()
                .nom("Maarif").adresse("Biranzarane").build();
        centreRepository.save(centre1);
        Centre centre2 = Centre.builder()
                .nom("Oranges").adresse("Oulfa").build();
        centreRepository.save(centre2);
        Etudiant et1 = Etudiant.builder()
                .nom("Adnani").prenom("Brahim").genre(Genre.Homme)
                .centre(centre1).build();
        etudiantRepository.save(et1);
    }
}
