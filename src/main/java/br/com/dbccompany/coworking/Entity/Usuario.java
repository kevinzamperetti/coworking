package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;

@Entity
@SequenceGenerator( allocationSize = 1, name = "USUARIOS_SEQ", sequenceName = "USUARIOS_SEQ" )
public class Usuario extends AbstractEntity {

    @Id
    @Column( name = "id_usuario" )
    @GeneratedValue( generator = "USUARIOS_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @Column( name = "nome", length = 100, nullable = false )
    private String nome;

    @Column( name = "email", length = 100, nullable = false, unique = true )
    private String email;

    @Column( name = "login", length = 100, nullable = false, unique = true )
    private String login;

    @Column( name = "senha", length = 100, nullable = false )
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
