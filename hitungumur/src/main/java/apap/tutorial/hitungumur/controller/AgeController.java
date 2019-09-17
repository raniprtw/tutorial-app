package apap.tutorial.hitungumur.controller;

// import ini
import apap.tutorial.hitungumur.model.Age;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class AgeController {
    private String getHitungUmurPage(Optional<LocalDate> birthdate, Model model) {
        if (birthdate.isPresent()) {
            final Age currentAge = new Age(birthdate.get());
            model.addAttribute("age", currentAge);
            model.addAttribute("birthdate", birthdate.get());
        } else {
            model.addAttribute("age", null);
            model.addAttribute("birthdate", "-");
        }
        return "HitungUmurPage";
    }

    @GetMapping(value = "/hitung-umur")
    public String hitungUmur(
            @RequestParam(value = "birthdate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    Optional<LocalDate> birthDate,
            Model model) {
        return getHitungUmurPage(birthDate, model);
    }

    @PostMapping(value = "/hitung-umur/{birthdate}")
    public String hitungUmurWithPathVariable(
            @PathVariable(value = "birthdate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                Optional<LocalDate> birthdate,
            Model model) {
        return getHitungUmurPage(birthdate, model);
    }
}