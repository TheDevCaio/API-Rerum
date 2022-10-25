package com.servico.backservico.entity;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Server;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "servico")
@Data
public class Servico {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String nomeCliente;
    @Temporal(TemporalType.DATE)
    private Date dataInicio=new Date(id);
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    private String descricaoServico;
    private Double valorServico;
    private Double valorPago;
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    private String status;//"pendente","realizado" ou "cancelado"


 
}
