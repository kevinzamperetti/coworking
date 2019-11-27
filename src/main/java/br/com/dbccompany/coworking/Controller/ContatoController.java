package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Contato;
import br.com.dbccompany.coworking.Service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/contato" )
public class ContatoController {

    @Autowired
    ContatoService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Contato> todosContatos() {
        return service.todosContatos();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public Contato novoContato( @RequestBody Contato contato ) throws Exception {
        return service.salvar( contato );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Contato editarContato( @PathVariable Integer id, @RequestBody Contato contato ) {
        return service.editar( id, contato );
    }
}
