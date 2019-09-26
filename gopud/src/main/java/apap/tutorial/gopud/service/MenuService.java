package apap.tutorial.gopud.service;

import java.util.List;

import apap.tutorial.gopud.model.MenuModel;

public interface MenuService {
	void addMenu(MenuModel menu);
	List<MenuModel> findAllMenuByIdRestoran(long idRestoran);
}
