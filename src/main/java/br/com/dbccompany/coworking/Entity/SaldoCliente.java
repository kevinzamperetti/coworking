package br.com.dbccompany.coworking.Entity;

import br.com.dbccompany.coworking.Enum.TipoContratacao;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "saldos_clientes")
@SequenceGenerator( allocationSize = 1, name = "SALDOS_CLIENTES_SEQ", sequenceName = "SALDOS_CLIENTES_SEQ" )
public class SaldoCliente {

    @EmbeddedId
    private SaldoClienteId id;

    @Enumerated( EnumType.STRING )
    @Column( name = "tipo_contratacao", nullable = false )
    private TipoContratacao tipoContratacao;

    @Column( name = "quantidade", nullable = false )
    private Double quantidade;

    @Column( name = "vencimento", nullable = false )
    private Date vencimento;

    @OneToMany( mappedBy = "saldoCliente")
    private List<Acesso> acesso = new ArrayList<>();

    public SaldoClienteId getId() {
        return id;
    }

    public void setId(SaldoClienteId id) {
        this.id = id;
    }

    public TipoContratacao getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(TipoContratacao tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public List<Acesso> getAcesso() {
        return acesso;
    }

    public void setAcesso(List<Acesso> acesso) {
        this.acesso = acesso;
    }
}
