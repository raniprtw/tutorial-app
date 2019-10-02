package apap.tutorial.gopud.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<MenuModel> findMenuById(long id){
        return menuDb.findById(id);
    }

    @Override public MenuModel changeMenu(MenuModel menuModel) {
        MenuModel targetMenu = menuDb.findById(menuModel.getId()).get();
        try {
            targetMenu.setNama(menuModel.getNama());
            targetMenu.setDeskripsi(menuModel.getDeskripsi());
            targetMenu.setHarga(menuModel.getHarga());
            targetMenu.setDurasiMasak(menuModel.getDurasiMasak());
            menuDb.save(targetMenu);
            return targetMenu;
        } catch (NullPointerException nullException) {
            return null;
        }

    }

    @Override public void deleteMenu(MenuModel menuModel){
        menuDb.delete(menuModel);
    }

}
