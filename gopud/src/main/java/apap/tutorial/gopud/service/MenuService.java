package apap.tutorial.gopud.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import apap.tutorial.gopud.model.MenuModel;

import javax.swing.text.html.Option;

public interface MenuService {
	void addMenu(MenuModel menu);
	List<MenuModel> findAllMenuByIdRestoran(long idRestoran);
	MenuModel changeMenu(MenuModel menuModel);
	Optional<MenuModel> findMenuById(long id);
	void deleteMenu(MenuModel menuModel);
	Optional<MenuModel> getMenuByNamaAndHarga(String nama, BigInteger harga);
}
