package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Pacote;
import br.com.dbccompany.coworking.Service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/pacote" )
public class PacoteController {

    @Autowired
    PacoteService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Pacote> todosPacotes() {
        return service.todosPacotes();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public Pacote novoPacote( @RequestBody Pacote pacote ) {
        return service.salvar( pacote );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Pacote editarPacote( @PathVariable Integer id, @RequestBody Pacote pacote ) {
        return service.editar( id, pacote );
    }
}
