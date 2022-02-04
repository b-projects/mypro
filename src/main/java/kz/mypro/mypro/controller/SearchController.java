package kz.mypro.mypro.controller;


import kz.mypro.mypro.dto.PersonDto;
import kz.mypro.mypro.entity.QueryMsg;
import kz.mypro.mypro.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Date;

@Controller
@RestController
@AllArgsConstructor
@Log
public class SearchController {

    private final PersonService personService;

    @GetMapping ("/search")
    public void searchPersonByIin(@RequestParam String iin) {
        personService.searchPersonByIin(iin);
    }
}
