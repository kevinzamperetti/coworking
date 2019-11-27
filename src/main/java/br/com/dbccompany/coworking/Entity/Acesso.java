package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "acessos")
@SequenceGenerator( allocationSize = 1, name = "ACESSOS_SEQ", sequenceName = "ACESSOS_SEQ" )
public class Acesso extends AbstractEntity {

    @Id
    @Column( name = "id_acesso" )
    @GeneratedValue( generator = "ACESSOS_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @ManyToOne( cascade = CascadeType.MERGE)
    @JoinColumns( {
            @JoinColumn( name = "id_cliente_saldo_cliente", referencedColumnName = "id_cliente"),
            @JoinColumn( name = "id_espaco_saldo_cliente", referencedColumnName = "id_espaco")
    } )
    private SaldoCliente saldoCliente;

    @Column( name = "is_entrada", nullable = false )
    private  boolean isEntrada;

    @Column( name = "is_excecao", nullable = false )
    private  boolean isExcecao;

    @Column( name = "data", length = 10, nullable = false )
    private Date data;

    public SaldoCliente getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(SaldoCliente saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public boolean getIsEntrada() {
        return isEntrada;
    }

    public void setIsEntrada(boolean entrada) {
        isEntrada = entrada;
    }

    public boolean getIsExcecao() {
        return isExcecao;
    }

    public void setIsExcecao(boolean excecao) {
        isExcecao = excecao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
