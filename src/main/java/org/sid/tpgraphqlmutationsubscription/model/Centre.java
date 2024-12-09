package org.sid.tpgraphqlmutationsubscription.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="centre")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name="nom_centre", nullable=false)
    String nom;
    @Column(name="adresse_centre", nullable=false)
    String adresse;
    //Un centre peut accueillir plusieurs étudiants
    @OneToMany(mappedBy = "centre")
    private List<Etudiant> etudiants;

}
