package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.TipoContato;
import br.com.dbccompany.coworking.Service.TipoContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/api/tipocontato" )
public class TipoContatoController {

    @Autowired
    TipoContatoService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<TipoContato> todosTipoContatos() {
        return service.todosTipoContatos();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public TipoContato novoTipoContato( @RequestBody TipoContato tipoContato ) throws Exception {
        return service.salvar( tipoContato );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public TipoContato editarTipoContato( @PathVariable Integer id, @RequestBody TipoContato tipoContato ) {
        return service.editar( id, tipoContato );
    }
}
