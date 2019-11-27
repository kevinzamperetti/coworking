package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.ClienteXPacote;
import br.com.dbccompany.coworking.Service.ClienteXPacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/clientexpacote" )
public class ClienteXPacoteController {

    @Autowired
    ClienteXPacoteService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<ClienteXPacote> todosClientesXPacotes() {
        return service.todosClientesXPacotes();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public ClienteXPacote novoClienteXPacote( @RequestBody ClienteXPacote clienteXPacote ) {
        return service.salvar( clienteXPacote );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public ClienteXPacote editarClienteXPacote( @PathVariable Integer id, @RequestBody ClienteXPacote clienteXPacote ) {
        return service.editar( id, clienteXPacote );
    }
}
