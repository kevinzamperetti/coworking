package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.EspacoXPacote;
import br.com.dbccompany.coworking.Service.EspacoXPacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/espacoxpacote" )
public class EspacoXPacoteController {

    @Autowired
    EspacoXPacoteService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<EspacoXPacote> todosEspacosXPacotes() {
        return service.todosEspacosXPacotes();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public EspacoXPacote novoEspacoXPacote( @RequestBody EspacoXPacote espacoXPacote ) {
        return service.salvar( espacoXPacote );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public EspacoXPacote editarEspacoXPacote( @PathVariable Integer id, @RequestBody EspacoXPacote espacoXPacote ) {
        return service.editar( id, espacoXPacote );
    }
}
