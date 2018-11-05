
package br.com.sistemadsdois.entidade;


public class Pedidos {
    
    private String tipo;
    private String preco;
    private String quantidade;
    private String status;
    private String acompanhamento;
    private String troco;

    public void setTroco(String troco) {
        this.troco = troco;
    }

    public String getTroco() {
        return troco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }
    
    
}
