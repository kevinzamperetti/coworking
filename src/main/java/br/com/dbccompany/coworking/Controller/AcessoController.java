package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Acesso;
import br.com.dbccompany.coworking.Service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/acesso" )
public class AcessoController {

    @Autowired
    AcessoService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Acesso> todosAcessos() {
        return service.todosAcessos();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public String novoAcesso( @RequestBody Acesso acesso ) throws Exception {
        return service.salvar( acesso );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Acesso editarAcesso( @PathVariable Integer id, @RequestBody Acesso acesso ) {
        return service.editar( id, acesso );
    }
}
