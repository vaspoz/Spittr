package edu.vaspoz.spittr.api;

import edu.vaspoz.spittr.Spittle;
import edu.vaspoz.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Vasilii_Pozdeev on 08-Jan-16.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleApiController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleApiController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {

        return spittleRepository.findSpittles(max, count);

    }
}
