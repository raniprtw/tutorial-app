package apap.tutorial.gopud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@Qualifier("restoranServiceImpl")
	@Autowired
	RestoranService restoranService;
	
	@RequestMapping(value="/menu/add/{idRestoran}", method=RequestMethod.GET)
	private String addProductFormPage(@PathVariable(value="idRestoran") Long idRestoran
			, Model model) {
		MenuModel menu = new MenuModel();
		RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
		menu.setRestoran(restoran);
		
		model.addAttribute("menu", menu);
		
		return "form-add-menu";
	}

	@RequestMapping(value = "menu/add", method = RequestMethod.POST)
	private String addProductSubmit(@ModelAttribute MenuModel menu, Model model){
		menuService.addMenu(menu);
		model.addAttribute("nama", menu.getNama());

		return "add-menu";
	}

	//API menuju halaman form change restoran
	@RequestMapping(value = "menu/change/{id}", method = RequestMethod.GET)
	public String changeMenuFormPage(@PathVariable Long id, Model model) {
		MenuModel existingMenu = menuService.findMenuById(id).get();
		model.addAttribute("menu", existingMenu);
		return "form-change-menu";
	}

	//API untuk submit
	@RequestMapping(value = "menu/change/{id}", method = RequestMethod.POST)
	public String changeMenuSubmit(@PathVariable Long id, @ModelAttribute MenuModel menu, Model model) {
		MenuModel newMenuData = menuService.changeMenu(menu);
		model.addAttribute("menu", newMenuData);
		return "change-menu";
	}

	//Delete menu
	@RequestMapping(value = "menu/delete/{id}", method=RequestMethod.GET)
	private String deleteMenu (@PathVariable Long id, @ModelAttribute MenuModel menu, Model model){
		MenuModel deletedMenu = menuService.findMenuById(id).get();
		model.addAttribute("menu", deletedMenu.getNama());
		menuService.deleteMenu(deletedMenu.getId());
		return "delete-menu";
	}

	@RequestMapping(value="/menu/delete", method=RequestMethod.POST)
	private String delete(@ModelAttribute RestoranModel restoran, Model model){
		System.out.println(restoran.getIdRestoran());
		for (MenuModel menu : menuService.getListMenuOrderByHargaAsc(restoran.getIdRestoran())){
			System.out.println(menu);
			menuService.deleteMenu(menu.getId());
		}
		//model.addAttribute("menu", "Delete Menu");
		return "delete-menu";
	}
}
