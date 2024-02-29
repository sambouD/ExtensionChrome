package com.etensionChrome.etensionChrome.Controller;

import com.etensionChrome.etensionChrome.Entity.PeriodiciteEntity;
import com.etensionChrome.etensionChrome.Entity.QuotidienneConfigEntity;
import com.etensionChrome.etensionChrome.Entity.TypePeriode;
import com.etensionChrome.etensionChrome.Service.PeriodiciteService;
import com.etensionChrome.etensionChrome.repository.QuotidienneConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "chrome-extension://gipjopdimhamkjfecdfmmhokelcadibn", allowedHeaders = "*")
@RequestMapping("/periodicites")
public class TestController {

    @Autowired
    private PeriodiciteService periodiciteService;
    @Autowired
    private QuotidienneConfigRepository quotidienneConfigEntityRepository;

    @GetMapping
    public String showPeriodicites (Model model) {
        QuotidienneConfigEntity quotidienneConfigEntity = new QuotidienneConfigEntity();
        model.addAttribute("quotidienneConfigEntity", quotidienneConfigEntity);
        model.addAttribute("periodicite", new PeriodiciteEntity());

        return "periodiciteForm";
    }

    @PostMapping("/new")
    public String savePeriodicite(@ModelAttribute("periodicite") PeriodiciteEntity periodicite,
                                  Model model){
        periodiciteService.savePeriodicite(periodicite);

        return "redirect:/periodiciteForm";
    }

    @ModelAttribute("typesPeriode")
    public TypePeriode[] typesPeriode() {
        return TypePeriode.values();
    }


}
