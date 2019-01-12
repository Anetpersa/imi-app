
package application.controllers;

import application.models.RezervacijaModel;
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
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    public RezervacijaService getRezervacijaService() {
        return rezervacijaService;
    }

    public void setRezervacijaService(RezervacijaService rezervacijaService) {
        this.rezervacijaService = rezervacijaService;
    }

    @RequestMapping(value = "/dodaj-rezervaciju", method = RequestMethod.GET)
    public String vratiStranicuZaDodavanjeRezervacije(Model model) {
        
        model.addAttribute("novaRezervacija", new RezervacijaModel());

        return "dodaj-rezervaciju";
    }

    @RequestMapping(value = "/dodaj-rezervaciju", method = RequestMethod.POST)
    public String dodajRezervaciju(@Valid @ModelAttribute("novaRezervacija") RezervacijaModel novaRezervacija,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
                        
            return "dodaj-rezervaciju";
        } else {
            rezervacijaService.dodajRezervaciju(novaRezervacija);
            
            return "redirect:/moje-rezervacije";
        }

    }

    @RequestMapping(value = "/lista-uredjaja-za-rezervisanje", method = RequestMethod.GET)
    public String listajUredjajeZaRezervisanje(Model model) {

        model.addAttribute("listaUredjajaZaRezervisanje", rezervacijaService.listaRezervacija()); //TODO: vidi ovo

        return "lista-uredjaja-za-rezervisanje";
    }

    @RequestMapping("/promena-rezervacije")
    public String promenaRezervacije(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("promenjenaRezervacija", rezervacijaService.pronadjiRezervaciju(id));
        
        return "promeni-rezervaciju";
        
    }
    
  @RequestMapping(value = "/promeni-rezervaciju", method = RequestMethod.POST)
   public String menjajRezervaciju(
            @Valid @ModelAttribute("promenjenaRezervacija") RezervacijaModel promenjenaRezervacija,
            BindingResult bindingResult, Model model) {
       
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
            
            return "promeni-rezervaciju";
        } else {
            rezervacijaService.promeniRezervaciju(promenjenaRezervacija);
            
            return "redirect:/moje-rezervacije";
        }
    }
   
   @RequestMapping("/brisanje-rezervacije")
    public String brisanjeRezervacije(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("obrisanaRezervacija", rezervacijaService.pronadjiRezervaciju(id));
        
        return "obrisi-rezervaciju";
        
    }
    
    @RequestMapping(value = "/obrisi-rezervaciju", method = RequestMethod.POST)
   public String obrisiRezervaciju(
            @Valid @ModelAttribute("obrisanIstrazivac") RezervacijaModel obrisanarezervacija) {
       
            rezervacijaService.obrisiRezervaciju(obrisanaRezervacija);
            
            return "redirect:/moje-rezervacije";
    }

}


