package apap.tutorial.gopud.service;

import java.util.ArrayList;
import java.util.List;
import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

@Service
public class RestoranInMemoryService implements RestoranService{
	private List<RestoranModel> listRestoran;
	
	//Constructor
	public RestoranInMemoryService() {
		listRestoran = new ArrayList<>();
	}
	
	@Override
	public void addRestoran(RestoranModel restoran) {
		listRestoran.add(restoran);
	}
	
	@Override
	public List<RestoranModel> getRestoranList(){
		return listRestoran;
	}

	@Override
    public RestoranModel getRestoranByIdRestoran(String idRestoran) {
        for (RestoranModel restoran : getRestoranList()) {
            if (restoran.getIdRestoran().equals(idRestoran)) {
                return restoran;
            }
        }
        return null;
    }
	
	@Override
    public void deleteRestoran(String idRestoran) {
        int x;
        for (x = 0; x < getRestoranList().size(); x++) {
            if (getRestoranList().get(x).getIdRestoran().equals(idRestoran)) {
                break;
            }
        }
        getRestoranList().remove(x);
    }
	
}
