
package application.controllers;

import application.models.UredjajModel;
import application.services.UredjajService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UredjajController {

    @Autowired
    private UredjajService uredjajService;

    public UredjajService getUredjajService() {
        return uredjajService;
    }

    public void setUredjajService(UredjajService uredjajService) {
        this.uredjajService = uredjajService;
    }

    @RequestMapping(value = "/dodaj-uredjaj", method = RequestMethod.GET)
    public String vratiStranicuZaDodavanjeUredjaja(Model model) {
        
        model.addAttribute("noviUredjaj", new UredjajModel());

        return "dodaj-uredjaj";
    }

    @RequestMapping(value = "/dodaj-uredjaj", method = RequestMethod.POST)
    public String dodajUredjaj(@Valid @ModelAttribute("noviUredjaj") UredjajModel noviUredjaj,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
                        
            return "dodaj-uredjaj";
        } else {
            uredjajService.dodajUredjaj(noviUredjaj);
            
            return "redirect:/lista-uredjaja";
        }

    }

    @RequestMapping(value = "/lista-uredjaja", method = RequestMethod.GET)
    public String listajUredjaje(Model model) {

        model.addAttribute("listaUredjaja", uredjajService.listaUredjaja());

        return "lista-uredjaja";
    }

    @RequestMapping("/promena-uredjaja")
    public String promenaUredjaja(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("promenjenUredjaj", uredjajService.pronadjiUredjaj(id));
        
        return "promeni-uredjaj";
        
    }
    
  @RequestMapping(value = "/menjaj-uredjaj", method = RequestMethod.POST)
   public String menjajUredjaja(
            @Valid @ModelAttribute("promenjenUredjaj") UredjajModel promenjenUredjaj,
            BindingResult bindingResult, Model model) {
       
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
            
            return "promeni-uredjaj";
        } else {
            uredjajService.promeniUredjaj(promenjenUredjaj);
            
            return "redirect:/lista-uredjaja";
        }
    }
   
   @RequestMapping("/brisanje-uredjaja")
    public String brisanjeUredjaja(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("obrisanUredjaj", uredjajService.pronadjiUredjaj(id));
        
        return "obrisi-uredjaj";
        
    }
    
    @RequestMapping(value = "/brisi-uredjaj", method = RequestMethod.POST)
   public String obrisiUredjaj(
            @Valid @ModelAttribute("obrisanUredjaj") UredjajModel obrisanUredjaj) {
       
            uredjajService.obrisiUredjaj(obrisanUredjaj);
            
            return "redirect:/lista-uredjaja";
    }

}


