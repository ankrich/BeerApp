package au.com.ankrich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by arichharia on 29/06/2016.
 */
@Controller
public class BeerController {

    @Autowired
    private DBRepository repo;

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String importParse(@RequestParam("myFile") MultipartFile myFile) {
        // ... do whatever you want with 'myFile'
        // Redirect to a successful upload page
        System.out.println("file has been uploaded " + myFile.toString());
        return "redirect:uploadSuccess.html";
    }

    @RequestMapping(value = "/beer", method = RequestMethod.GET)
    public String greetingFrom(Model model) {
        model.addAttribute("beer", new Beer());
        return "add";
    }


    @RequestMapping(value = "/beer", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Beer beer, Model model) {
        model.addAttribute("beer", beer);
        repo.saveAndFlush(beer);
        return "add";
    }

    @RequestMapping(value = "/AllBeers", method = RequestMethod.GET)
    public String getAllGreetings(Model model) {
                model.addAttribute("beers", findAll());
        return "showAllBeer";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("beer", new Beer());
        return "add";
    }
    private List<Beer> findAll() {
        return  repo.findAll();
    }
}


