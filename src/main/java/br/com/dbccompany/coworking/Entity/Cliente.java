package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "clientes")
@SequenceGenerator( allocationSize = 1, name = "CLIENTES_SEQ", sequenceName = "CLIENTES_SEQ" )
public class Cliente extends AbstractEntity {

    @Id
    @Column( name = "id_cliente" )
    @GeneratedValue( generator = "CLIENTES_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @Column( name = "nome", length = 100, nullable = false )
    private String nome;

    @Column( name = "cpf", length = 14, nullable = false, unique = true )
    private String cpf;

    @Column( name = "data_nascimento", length = 10, nullable = false )
    private Date dataNascimento;

    @OneToMany( mappedBy = "cliente", cascade = CascadeType.ALL )
    private List<Contato> contatos = new ArrayList<>();

    @OneToMany( mappedBy = "cliente", cascade = CascadeType.ALL )
    private List<Contratacao> contratacoes = new ArrayList<>();

    @OneToMany ( mappedBy = "idCliente", cascade = CascadeType.ALL)
    private List<ClienteXPacote> listaClientesPacotes = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Contratacao> getContratacoes() {
        return contratacoes;
    }

    public void setContratacoes(List<Contratacao> contratacoes) {
        this.contratacoes = contratacoes;
    }

    public List<ClienteXPacote> getListaClientesPacotes() {
        return listaClientesPacotes;
    }

    public void setListaClientesPacotes(List<ClienteXPacote> listaClientesPacotes) {
        this.listaClientesPacotes = listaClientesPacotes;
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
