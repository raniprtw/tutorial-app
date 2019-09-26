package apap.tutorial.gopud.service;

import java.util.List;

import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.tutorial.gopud.model.MenuModel;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDb menuDb;

    @Override
    public void addMenu(MenuModel menu) {
		menuDb.save(menu);
	}

    public List<MenuModel> findAllMenuByIdRestoran(long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);
    }

    /*@Override public List<MenuModel> findAllMenuByIdRestoran(Long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);
    }*/

}
