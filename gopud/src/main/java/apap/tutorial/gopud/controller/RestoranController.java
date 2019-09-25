package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
	@Autowired
	private RestoranService restoranService;
	
	//URL mapping add
	@RequestMapping("/restoran/add")
	public String add(
			@RequestParam(value = "idRestoran", required=true) String idRestoran,
			@RequestParam(value = "nama", required = true) String nama,
			@RequestParam(value = "alamat", required = true) String alamat,
			@RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon, 
			Model model) {
		
		//Membuat object RestoranModel
		RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);
		
		//Memanggil service addRestoran
		restoranService.addRestoran(restoran);
		
		//Add variable nama restoran ke "namaResto" untuk dirender
		model.addAttribute("namaResto", nama);
		
		//return view template
		return "add-restoran";
				
	}
	
	// URL mapping view
	@RequestMapping(path="/restoran/view/id-restoran/{idRestoran}")
	public String view(
			//Req parameter untuk dipass
			@PathVariable(value = "idRestoran") String idRestoran,
			Model model) {
//		System.out.println(idRestoran);
		
		//Mengambil object RestoranModel yang dituju
		RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
		
		//Add model restoran ke "resto" untuk dirender
		model.addAttribute("resto", restoran);
		
		//return view template
		return "view-restoran";
	}
		
	//URL mapping viewAll
	@RequestMapping("/restoran/viewall")
    public String viewall(Model model) {
        
		//Mengambil semua objek RestoranModel yang ada
		List<RestoranModel> listRestoran = restoranService.getRestoranList();
        
		//Add model restoran ke "resto" untuk di render
		model.addAttribute("restoList", listRestoran);
        
        return "viewall-restoran";
    }
	
	@RequestMapping("restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
    public String updateNomorTelepon(
            @PathVariable(value = "idRestoran") String idRestoran,
            @PathVariable(value = "nomorTelepon") Integer nomorTelepon,
            Model model
            ) {
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        restoran.setNomorTelepon(nomorTelepon);
        model.addAttribute("resto", restoran);
        return "view-restoran";
    }
	
	@RequestMapping("restoran/delete/id/{idRestoran}")
    public String delete(
            @PathVariable(value = "idRestoran") String idRestoran,
            Model model
            ) {
        restoranService.deleteRestoran(idRestoran);
        return viewall(model);
    }
	
			
}
