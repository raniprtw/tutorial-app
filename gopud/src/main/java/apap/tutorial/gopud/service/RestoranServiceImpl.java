package apap.tutorial.gopud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import apap.tutorial.gopud.repository.RestoranDb;

import apap.tutorial.gopud.model.RestoranModel;

@Primary
@Service
@Transactional
public class RestoranServiceImpl implements RestoranService {
	
	@Autowired
	private RestoranDb restoranDb;
	
	@Override public void addRestoran(RestoranModel restoranModel) {
		//System.out.println("masuk impl " + restoranModel.getNama());
		restoranDb.save(restoranModel);
		//System.out.println("kelar impl");
	}

	@Override public List<RestoranModel> getRestoranList() {
		return restoranDb.findAll();
	}

	@Override public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
		return restoranDb.findByIdRestoran(idRestoran);
	}

	@Override public boolean deleteRestoran(RestoranModel restoran) {
		if(restoran.getListMenu().size()==0){
			restoranDb.delete(restoran);
			return true;
		}
		else{
			return false;
		}
	}

	@Override public RestoranModel changeRestoran(RestoranModel restoranModel) {
		// Mengambil object restoran yang ingin diubah
		RestoranModel targetRestoran = restoranDb.findById(restoranModel.getIdRestoran()).get();

		try {
			//targetRestoran.removeName();
			targetRestoran.setNama(restoranModel.getNama());
			targetRestoran.setAlamat(restoranModel.getAlamat());
			targetRestoran.setNomorTelepon(restoranModel.getNomorTelepon());
			restoranDb.save(targetRestoran);
			System.out.println(targetRestoran.getNama());
			return targetRestoran;
		}
		
		catch (NullPointerException nullException){
			System.out.println("---retrurn null---");
			return null;
		}
	}

}
