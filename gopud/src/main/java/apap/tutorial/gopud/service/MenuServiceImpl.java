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
        // Mengambil object menu yang ingin diubah
        MenuModel targetMenu = menuDb.findById(menuModel.getId()).get();
        System.out.println(menuModel.getDeskripsi());

        try {
            //targetMenu.removeName(); DEKRIPSI DURASI HARGA NAMA
            targetMenu.setNama(menuModel.getNama());
            targetMenu.setHarga(menuModel.getHarga());
            targetMenu.setDurasiMasak(menuModel.getDurasiMasak());
            targetMenu.setDeskripsi(menuModel.getDeskripsi());

            menuDb.save(targetMenu);
            return targetMenu;
        }

        catch (NullPointerException nullException){
            System.out.println("---retrurn null---");
            return null;
        }
    }

}
