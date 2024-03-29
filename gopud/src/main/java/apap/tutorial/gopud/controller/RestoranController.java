package apap.tutorial.gopud.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
	@Qualifier("restoranServiceImpl")
	@Autowired
	private RestoranService restoranService;
	
	@Autowired
	private MenuService menuService;
/*
	@RequestMapping("/")
	public String home() {return "home";}*/
	
	//URL mapping add
	@RequestMapping(value="/restoran/add", method = RequestMethod.GET)
	public String addRestoranFormPage(Model model) {
		
		//Membuat object RestoranModel
		RestoranModel newRestoran = new RestoranModel();
		
		//Add variable nama restoran ke "namaResto" untuk dirender
		model.addAttribute("restoran", newRestoran);
		
		//return view template
		return "form-add-restoran";
				
	}
	
	//URL mapping untuk submit habis add
	@RequestMapping(value="/restoran/add", method=RequestMethod.POST)
	public String addrestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
		restoranService.addRestoran(restoran);
		//System.out.println(restoran.getNama());
		model.addAttribute("namaResto", restoran.getNama());
		return "add-restoran";
	}
	
	// URL mapping view
	@RequestMapping(path="/restoran/view", method=RequestMethod.GET)
	public String view(@RequestParam(value = "idRestoran") Long idRestoran, Model model) {

		//Mengambil object RestoranModel yang dituju
		RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();

		List<MenuModel> menuList = menuService.getListMenuOrderByHargaAsc(restoran.getIdRestoran());
		restoran.setListMenu(menuList);
		System.out.println(restoran.getIdRestoran());

		//Add model restoran ke "resto" untuk dirender
		model.addAttribute("menuList", menuList);
		model.addAttribute("resto", restoran);

		//return view template
		return "view-restoran";
	}

	//API menuju halaman form change restoran
	@RequestMapping(value="restoran/change/{idRestoran}", method=RequestMethod.GET)
	public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
		RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
		model.addAttribute("restoran", existingRestoran);
		return "form-change-restoran";
	}
	
	//API untuk submit
	@RequestMapping(value="restoran/change/{idRestoran}", method=RequestMethod.POST)
	public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
		System.out.println("---sebelum method changeRestoran---");
		RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
		System.out.println("---setelah method changeRestoran---");
		System.out.println(newRestoranData.getNama());
		model.addAttribute("nama", newRestoranData.getNama());
		return "change-restoran";
	}
	
	 //URL mapping viewAll

	 @RequestMapping(value="/restoran/view-all", method=RequestMethod.GET) public String viewAll(Model model) {

		 //Mengambil semua objek RestoranModel yang ada List<RestoranModel>
		 List<RestoranModel> listRestoran = restoranService.getRestoranList();

		 Collections.sort(listRestoran);

		 //Add model restoran ke "resto" untuk di render
		 model.addAttribute("restoList", listRestoran);

		 return "view-all";

	}

	 /**
	 * @RequestMapping(
	 * "restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
	 * public String updateNomorTelepon(
	 *
	 * @PathVariable(value = "idRestoran") String idRestoran,
	 *
	 * @PathVariable(value = "nomorTelepon") Integer nomorTelepon, Model model ) {
	 * RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
	 * restoran.setNomorTelepon(nomorTelepon); model.addAttribute("resto",
	 * restoran); return "view-restoran"; }
*/

	 @RequestMapping(value="restoran/delete/{idRestoran}", method=RequestMethod.GET)
	 public String delete(@PathVariable(value = "idRestoran") Long idRestoran, Model model ) {
		 RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
		 restoranService.deleteRestoran(existingRestoran);
		 return "delete-restoran";
	 }


}
