package br.com.hiago640.vaxlog.dto;

import java.time.LocalDate;

public class AplicacaoRequest {

    public Long usuarioId;
    public Long vacinaId;
    public String dose;
    public LocalDate dataAplicacao;
    public String localAplicacao;
    public String lote;
    public String observacao;
}