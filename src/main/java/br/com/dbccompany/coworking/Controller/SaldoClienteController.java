package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.SaldoCliente;
import br.com.dbccompany.coworking.Entity.SaldoClienteId;
import br.com.dbccompany.coworking.Service.SaldoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/saldocliente" )
public class SaldoClienteController {

    @Autowired
    SaldoClienteService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<SaldoCliente> todosSaldoClientes() {
        return service.todosSaldoClientes();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public SaldoCliente novoSaldoCliente( @RequestBody SaldoCliente saldoCliente ) {
        return service.salvar( saldoCliente );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public SaldoCliente editarSaldoCliente(@PathVariable SaldoClienteId id, @RequestBody SaldoCliente saldoCliente ) {
        return service.editar( id, saldoCliente );
    }
}
