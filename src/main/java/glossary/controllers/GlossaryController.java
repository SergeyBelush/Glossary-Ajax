package glossary.controllers;

import glossary.model.Glossary;
import glossary.repository.GlosarrySearchRepository;
import glossary.repository.GlossaryMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class GlossaryController {

    @Autowired
    private GlossaryMongoRepository glossaryRepository;

    @Autowired
    private GlosarrySearchRepository glossarySearchRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable home() {
        return glossaryRepository.findAll();
    }

    @RequestMapping(value = "/addGlossary", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addGlossary(@RequestBody Glossary glossary) {
        glossaryRepository.save(glossary);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Glossary> search(@RequestParam String search) {
        return glossarySearchRepository.searchGlossary(search);
    }
}
