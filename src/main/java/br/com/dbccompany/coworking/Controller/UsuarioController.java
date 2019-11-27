package br.com.dbccompany.coworking.Controller;

import br.com.dbccompany.coworking.Entity.Usuario;
import br.com.dbccompany.coworking.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping( "/api/usuario" )
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping( value = "/" )
    @ResponseBody
    public List<Usuario> todosUsuarios() {
        return service.todosUsuarios();
    }

    @PostMapping( value = "/novo" )
    @ResponseBody
    public Usuario novoUsuario( @RequestBody Usuario usuario ) throws NoSuchAlgorithmException {
        return service.salvar( usuario );
    }

    @PutMapping( value =  "/editar/{id}" )
    @ResponseBody
    public Usuario editarUsuario( @PathVariable Integer id, @RequestBody Usuario usuario ) {
        return service.editar( id, usuario );
    }
}
