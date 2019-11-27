package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Pagamento;
import br.com.dbccompany.coworking.Service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/pagamento" )
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Pagamento> todosPagamentos() {
        return service.todosPagamentos();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public Pagamento novoPagamento( @RequestBody Pagamento pagamento ) {
        return service.salvar( pagamento );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Pagamento editarPagamento( @PathVariable Integer id, @RequestBody Pagamento pagamento ) {
        return service.editar( id, pagamento );
    }
}
