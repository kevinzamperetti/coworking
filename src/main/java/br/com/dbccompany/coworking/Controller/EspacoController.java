package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Contratacao;
import br.com.dbccompany.coworking.Entity.Espaco;
import br.com.dbccompany.coworking.Service.ContratacaoService;
import br.com.dbccompany.coworking.Service.EspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/espaco" )
public class EspacoController {

    @Autowired
    EspacoService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Espaco> todosEspacos() {
        return service.todosEspacos();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public Espaco novoEspaco( @RequestBody Espaco espaco ) throws Exception {
        return service.salvar( espaco );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Espaco editarEspaco( @PathVariable Integer id, @RequestBody Espaco espaco ) {
        return service.editar( id, espaco );
    }
}
