package org.sid.tpgraphqlmutationsubscription.dto;


import org.sid.tpgraphqlmutationsubscription.enums.Genre;

public record EtudiantDTO (
        String nom,
        String prenom,
        Genre genre,
        Long centreId
){ }