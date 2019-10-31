package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;

public interface RestoranRestService {
    RestoranModel createRestoran(RestoranModel restoran);

    RestoranModel getRestoranByIdRestoran(Long idRestoran);

    void deleteRestoran(Long idRestoran);

    RestoranModel changeRestoran(Long idRestoran, RestoranModel restoran);

    List<RestoranModel> retrieveListRestoran();
}
