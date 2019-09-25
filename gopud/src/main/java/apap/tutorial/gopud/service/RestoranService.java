package apap.tutorial.gopud.service;

import java.util.List;

import apap.tutorial.gopud.model.RestoranModel;

public interface RestoranService {
	//Method untuk menambahkan restoran
	void addRestoran(RestoranModel restoran);
	
	//Method untuk mendapatkan semua data Restoran yang tersimpan
	List<RestoranModel> getRestoranList();
	
	//Method untuk mendapatkan data sebuah Restoran berdasarkan idRestoran
	RestoranModel getRestoranByIdRestoran(String idRestoran);
	
	//Method delete Restoran
	void deleteRestoran(String idRestoran);
	
}
