package edu.vaspoz.spittr.controller;

import edu.vaspoz.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Vasilii_Pozdeev on 24-Dec-15.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;


    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {

        this.spittleRepository = spittleRepository;

    }


    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            @RequestParam(defaultValue = Long.MAX_VALUE + "") long max,
            @RequestParam(defaultValue = "20") int count,
            Model model) {

        model.addAttribute("spittleList", spittleRepository.findSpittles(max, count));
        return "spittles";

    }


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam long spittle_id,
            Model model) {

        model.addAttribute(spittleRepository.findOne(spittle_id));
        return "spittle";

    }


    @RequestMapping(value = "{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable long spittleId,
            Model model) {

        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";

    }
}