package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "tipos_contatos")
@SequenceGenerator( allocationSize = 1, name = "TIPOS_CONTATOS_SEQ", sequenceName = "TIPOS_CONTATOS_SEQ" )
public class TipoContato extends AbstractEntity {

    @Id
    @Column( name = "id_tipo_contato" )
    @GeneratedValue( generator = "TIPOS_CONTATOS_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @Column( name = "nome", length = 100, nullable = false, unique = true )
    private String valor;

    @OneToMany( mappedBy = "tipoContato", cascade = CascadeType.ALL )
    private List<Contato> contatos = new ArrayList<>();

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
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
