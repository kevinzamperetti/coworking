package br.com.dbccompany.coworking.Entity;

import br.com.dbccompany.coworking.Funcoes.Conversao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "pacotes")
@SequenceGenerator( allocationSize = 1, name = "PACOTES_SEQ", sequenceName = "PACOTES_SEQ" )
public class Pacote extends AbstractEntity {

    @Id
    @Column( name = "id_pacote" )
    @GeneratedValue( generator = "PACOTES_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @Column( name = "valor", nullable = false )
    private Double valor;

    @Transient
    private String valorString = "";

    @OneToMany ( mappedBy = "idPacoteEspaco", cascade = CascadeType.ALL)
    private List<EspacoXPacote> listaPacotesEspacos = new ArrayList<>();

    @OneToMany ( mappedBy = "idPacoteCliente", cascade = CascadeType.ALL)
    private List<ClienteXPacote> listaPacotesClientes = new ArrayList<>();

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<EspacoXPacote> getListaPacotesEspacos() {
        return listaPacotesEspacos;
    }

    public void setListaPacotesEspacos(List<EspacoXPacote> listaPacotesEspacos) {
        this.listaPacotesEspacos = listaPacotesEspacos;
    }

    public List<ClienteXPacote> getListaPacotesClientes() {
        return listaPacotesClientes;
    }

    public void setListaPacotesClientes(List<ClienteXPacote> listaPacotesClientes) {
        this.listaPacotesClientes = listaPacotesClientes;
    }

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
        this.valor = Conversao.converteRealParaValor(valorString);
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
