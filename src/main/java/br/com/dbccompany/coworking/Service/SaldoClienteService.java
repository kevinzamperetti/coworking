package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Espaco;
import br.com.dbccompany.coworking.Entity.Pagamento;
import br.com.dbccompany.coworking.Entity.SaldoCliente;
import br.com.dbccompany.coworking.Entity.SaldoClienteId;
import br.com.dbccompany.coworking.Repository.EspacoRepository;
import br.com.dbccompany.coworking.Repository.PagamentoRepository;
import br.com.dbccompany.coworking.Repository.SaldoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaldoClienteService {

    @Autowired
    private SaldoClienteRepository saldoClienteRepository;

    @Autowired
    private EspacoRepository espacoRepository;

    @Transactional( rollbackFor = Exception.class )
    public SaldoCliente salvar(SaldoCliente saldoCliente ) {

        return saldoClienteRepository.save( saldoCliente );
    }

    @Transactional( rollbackFor = Exception.class )
    public SaldoCliente editar(SaldoClienteId id, SaldoCliente saldoCliente ){
        saldoCliente.setId( id );
        return saldoClienteRepository.save( saldoCliente );
    }

    public List<SaldoCliente> todosSaldoClientes() {
        return (List<SaldoCliente>) saldoClienteRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }
}
