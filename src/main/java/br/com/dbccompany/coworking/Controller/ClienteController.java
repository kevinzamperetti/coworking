package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Cliente;
import br.com.dbccompany.coworking.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/cliente" )
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Cliente> todosClientes() {
        return service.todosClientes();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public Cliente novoCliente( @RequestBody Cliente cliente ) throws Exception {
        return service.salvar( cliente );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Cliente editarCliente( @PathVariable Integer id, @RequestBody Cliente cliente ) {
        return service.editar( id, cliente );
    }
}
