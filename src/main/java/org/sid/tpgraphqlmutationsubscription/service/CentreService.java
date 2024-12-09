package org.sid.tpgraphqlmutationsubscription.service;


import org.sid.tpgraphqlmutationsubscription.model.Centre;
import org.sid.tpgraphqlmutationsubscription.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CentreService {

    @Autowired
    private CentreRepository centreRepository;

    // Fetch all centres
    public List<Centre> centres() {
        return centreRepository.findAll();
    }

    // Add a new centre
    public Centre addCentre(Centre centre) {
        return centreRepository.save(centre);
    }

    // Update an existing centre
    public Centre updateCentre(Long id, Centre centreDetails) {
        Centre centre = centreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Centre not found"));

        centre.setNom(centreDetails.getNom());
        centre.setAdresse(centreDetails.getAdresse());

        return centreRepository.save(centre);
    }

    // Delete a centre
    public String deleteCentre(Long id) {
        Optional<Centre> centre = centreRepository.findById(id);

        if (centre.isPresent()) {
            centreRepository.deleteById(id);
            return String.format("Centre with ID %s has been successfully deleted!", id);
        } else {
            return String.format("Centre with ID %s does not exist!", id);
        }
    }

    // Get a specific centre by ID
    public Centre getCentre(Long id) {
        return centreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Centre not found"));
    }
}
