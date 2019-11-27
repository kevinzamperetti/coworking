package br.com.dbccompany.coworking.Entity;

import br.com.dbccompany.coworking.Funcoes.Conversao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "espacos")
@SequenceGenerator( allocationSize = 1, name = "ESPACOS_SEQ", sequenceName = "ESPACOS_SEQ" )
public class Espaco extends AbstractEntity {

    @Id
    @Column( name = "id_espaco" )
    @GeneratedValue( generator = "ESPACOS_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @Column( name = "nome", length = 100, nullable = false, unique = true )
    private String nome;

    @Column( name = "qtd_pessoas", nullable = false )
    private Integer qtdPessoas;

    @Column( name = "valor", nullable = false )
    private Double valor;

    @Transient
    private String valorString = "";

    @OneToMany( mappedBy = "espaco", cascade = CascadeType.ALL )
    private List<Contratacao> contratacoes = new ArrayList<>();

    @OneToMany ( mappedBy = "idEspaco", cascade = CascadeType.ALL)
    private List<EspacoXPacote> listaEspacosPacotes = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(Integer qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
        this.valor = Conversao.converteRealParaValor( valorString );
    }

    public List<Contratacao> getContratacoes() {
        return contratacoes;
    }

    public void setContratacoes(List<Contratacao> contratacoes) {
        this.contratacoes = contratacoes;
    }

    public List<EspacoXPacote> getListaEspacosPacotes() {
        return listaEspacosPacotes;
    }

    public void setListaEspacosPacotes(List<EspacoXPacote> listaEspacosPacotes) {
        this.listaEspacosPacotes = listaEspacosPacotes;
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
