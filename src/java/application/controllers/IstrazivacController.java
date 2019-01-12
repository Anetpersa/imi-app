
package application.controllers;

import application.models.IstrazivacModel;
import application.services.IstrazivacService;
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
public class IstrazivacController {

    @Autowired
    private IstrazivacService istrazivacService;

    public IstrazivacService getIstrazivacService() {
        return istrazivacService;
    }

    public void setIstrazivacService(IstrazivacService istrazivacService) {
        this.istrazivacService = istrazivacService;
    }

    @RequestMapping(value = "/dodaj-istrazivaca", method = RequestMethod.GET)
    public String vratiStranicuZaDodavanjeIstrazivaca(Model model) {
        
        model.addAttribute("noviIstrazivac", new IstrazivacModel());

        return "dodaj-istrazivaca";
    }

    @RequestMapping(value = "/dodaj-istrazivaca", method = RequestMethod.POST)
    public String dodajIstrazivaca(@Valid @ModelAttribute("noviIstrazivac") IstrazivacModel noviIstrazivac,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
                        
            return "dodaj-istrazivaca";
        } else {
            istrazivacService.dodajIstrazivaca(noviIstrazivac);
            
            return "redirect:/lista-istrazivaca";
        }

    }

    @RequestMapping(value = "/lista-istrazivaca", method = RequestMethod.GET)
    public String listajIstrazivace(Model model) {

        model.addAttribute("listaIstrazivaca", istrazivacService.listaIstrazivaca());

        return "lista-istrazivaca";
    }

    @RequestMapping("/promena")
    public String promena(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("promenjenIstrazivac", istrazivacService.pronadjiIstrazivaca(id));
        
        return "promeni-istrazivaca";
        
    }
    
  @RequestMapping(value = "/menjaj-istrazivaca", method = RequestMethod.POST)
   public String menjajIstrazivaca(
            @Valid @ModelAttribute("promenjenIstrazivac") IstrazivacModel promenjenIstrazivac,
            BindingResult bindingResult, Model model) {
       
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
            
            return "promeni-istrazivaca";
        } else {
            istrazivacService.promeniIstrazivaca(promenjenIstrazivac);
            
            return "redirect:/lista-istrazivaca";
        }
    }
   
   @RequestMapping("/brisanje")
    public String brisanje(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("obrisanIstrazivac", istrazivacService.pronadjiIstrazivaca(id));
        
        return "obrisi-istrazivaca";
        
    }
    
    @RequestMapping(value = "/brisi-istrazivaca", method = RequestMethod.POST)
   public String obrisiistrazivaca(
            @Valid @ModelAttribute("obrisanIstrazivac") IstrazivacModel obrisanIstrazivac) {
       
            istrazivacService.obrisiIstrazivaca(obrisanIstrazivac);
            
            return "redirect:/lista-istrazivaca";
    }

}


