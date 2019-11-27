package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "contatos")
@SequenceGenerator( allocationSize = 1, name = "CONTATOS_SEQ", sequenceName = "CONTATOS_SEQ" )
public class Contato extends AbstractEntity {

    @Id
    @Column( name = "id_contato" )
    @GeneratedValue( generator = "CONTATOS_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @Column( name = "valor", length = 100, nullable = false )
    private String valor;

    @ManyToOne
    @JoinColumn( name = "fk_id_tipo_contato" )
    private TipoContato tipoContato;

    @ManyToOne
    @JoinColumn( name = "fk_id_cliente" )
    private Cliente cliente;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
