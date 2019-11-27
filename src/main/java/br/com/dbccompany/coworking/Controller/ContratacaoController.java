package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Contratacao;
import br.com.dbccompany.coworking.Service.ContratacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/contratacao" )
public class ContratacaoController {

    @Autowired
    ContratacaoService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Contratacao> todasContratacoes() {
        return service.todasContratacoes();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public String novoContratacao(@RequestBody Contratacao contratacao ) {
        return service.salvar( contratacao );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Contratacao editarContratacao( @PathVariable Integer id, @RequestBody Contratacao contratacao ) {
        return service.editar( id, contratacao );
    }
}
