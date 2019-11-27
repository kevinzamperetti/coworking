package br.com.dbccompany.coworking.Entity;

import br.com.dbccompany.coworking.Enum.TipoContratacao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "clientes_pacotes")
@SequenceGenerator( allocationSize = 1, name = "CLIENTES_PACOTES_SEQ", sequenceName = "CLIENTES_PACOTES_SEQ" )
public class ClienteXPacote extends AbstractEntity {

    @Id
    @Column( name = "id_cliente_pacote")
    @GeneratedValue( generator = "CLIENTES_PACOTES_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "fk_id_cliente" )
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn( name = "fk_id_pacote" )
    private Pacote idPacoteCliente;

    @Column( name = "quantidade", nullable = false )
    private Double quantidade;

    @OneToMany( mappedBy = "clienteXPacote", cascade = CascadeType.ALL )
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Pacote getIdPacoteCliente() {
        return idPacoteCliente;
    }

    public void setIdPacoteCliente(Pacote idPacoteCliente) {
        this.idPacoteCliente = idPacoteCliente;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
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
