package com.servico.backservico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;

import java.util.List;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> buscarTodos(){
        return servicoRepository.findAll();
    }

    public List<Servico> buscarServicosPagamentoPendente(){
            return servicoRepository.buscarServicosPagamentoPendente();

    }
    
    public List<Servico> buscarServicosCancelados(){
            return servicoRepository.buscarServicosCancelados();

    }

    public Servico inserir(Servico servico, String status){
        //return servicoRepository.save(servico);
        
        if(servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDataPagamento()==null){
            servico.setStatus(status= "pendente");
        }else{
            servico.setStatus(status= "realizado");  
        }
        Servico servicoBanco = servicoRepository.save(servico);
        return servicoBanco;

    }

    public Servico alterar(Servico servico, String status){
        if(servico.getValorPago()==null && servico.getValorPago()>0 && servico.getDataPagamento()!=null){
            servico.setStatus(status= "realizado");
            
            
        return servicoRepository.save(servico);
    }
        return servico;
}

public void excluir(Long id){
      Servico servico = servicoRepository.findById(id).get();
      servicoRepository.delete(servico);
}

}
