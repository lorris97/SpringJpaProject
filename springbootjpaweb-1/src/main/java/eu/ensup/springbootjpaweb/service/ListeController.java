package eu.ensup.springbootjpaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ListeController {

    @Autowired
    IFormationService iformationService;

    @Bean
    public FormationService iformationService() {
        return new FormationService();

    }

    public ListeController() {
        super();
    }

    public ListeController(IFormationService formationService) {
        super();
        this.iformationService = formationService;
    }

    @RequestMapping("/liste")
    public String home(Model model) {
        model.addAttribute("liste", iformationService.findAll());
        return "liste";
    }
}
