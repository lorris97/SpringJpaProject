package eu.ensup.springbootjpaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import eu.ensup.springbootjpaweb.dao.FormationRepository;
import eu.ensup.springbootjpaweb.domaine.Formation;

@Controller
@RequestMapping("/formationList")
public class FormationController {

	private FormationRepository FormationRepository;

	@Autowired
	public FormationController(FormationRepository FormationRepository) {
		this.FormationRepository = FormationRepository;
	}

	@RequestMapping(value = "/{theme}", method = RequestMethod.GET)
	public String listerLesFormations(@PathVariable("theme") String theme, Model model) {
		System.out.println("entree dans listerlesformation");
		List<Formation> listeFormation = FormationRepository.findByTheme(theme);
		if (listeFormation != null) {
			System.out.println(listeFormation);
			System.out.println(theme);
			model.addAttribute("listeFormation", listeFormation);
		}
		return "listeFormationParTheme";
	}

	@RequestMapping("/liste")
	public String home(Model model) {
		System.out.println("entree dans la liste");
		model.addAttribute("users", FormationRepository.findAll());
		return "liste";
	}

	@RequestMapping(value = "/{theme}", method = RequestMethod.POST)
	public String addToFormation(@PathVariable("theme") String theme, Formation formation) {
		formation.setTheme(theme);
		FormationRepository.save(formation);
		return "redirect:/Formation/{theme}";
	}

	

}
