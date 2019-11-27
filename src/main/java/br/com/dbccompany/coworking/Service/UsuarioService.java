package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Funcoes.Criptografia;
import br.com.dbccompany.coworking.Entity.Usuario;
import br.com.dbccompany.coworking.Repository.UsuarioRepository;
import br.com.dbccompany.coworking.Security.AccountCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername( String login ) {
        Usuario usuario = usuarioRepository.findByLogin( login );
        if ( usuario == null ) {
            throw new UsernameNotFoundException( login );
        }
        return new AccountCredentials( usuario );
    }

    @Transactional( rollbackFor = Exception.class )
    public Usuario salvar( Usuario usuario ) throws NoSuchAlgorithmException {

        String senha = usuario.getSenha();
        Criptografia criptografia = new Criptografia();
        String senhaCriptografada = criptografia.criptografarSenhaMD5( senha );
        if ( senhaCriptografada == null ) {
            System.out.println("Erro ao criptografar a senha");
            return null;
        } else {
            usuario.setSenha( senhaCriptografada );
            return usuarioRepository.save( usuario );
        }
    }

    @Transactional( rollbackFor = Exception.class )
    public Usuario editar( Integer id, Usuario usuario ){
        usuario.setId( id );
        return usuarioRepository.save( usuario );
    }

    public List<Usuario> todosUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }
}
