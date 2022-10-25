package com.servico.backservico.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Servico;



@RestController
@RequestMapping("api/servico")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @GetMapping("/")
    public List<Servico> buscarTodos(){
        return servicoService.buscarTodos();

    }

    @GetMapping("/pagamentosPentente")
    public antlr.collections.List buscarServicosPagamentoPendente(){
        return servicoService.buscarServicosPagamentoPendente();

    }
   
    @GetMapping("/cancelados")
    public List<Servico> buscarServicosCancelados(){
        return servicoService.buscarServicosCancelados();

}
@PostMapping("/")
public Servico inserir(@RequestBody Servico servico) {
    return ServicoService.inserir(servico);

}
@PostMapping("/")
public Servico alterar(@RequestBody Servico servico) {
    return ServicoService.alterar(servico);

}

@DeleteMapping("/{id}")
public ResponseEntity<Void> remover(@PathParam("id") Long id){
    ServicoService.excluir(id);
    return ResponseEntity.ok().build();
}

}
