package Models;

import Enums.ProdutosEnum;

public class ProdutoModel {
    private double preco;
    private ProdutosEnum setor;
    private String nome;
    private String idProduto;
    private int quantidadeProduto;

    public ProdutoModel(String nome, String idProduto, double preco, ProdutosEnum setor, int quantidadeProduto) {
        this.preco = preco;
        this.setor = setor;
        this.nome = nome;
        this.quantidadeProduto = quantidadeProduto;
        this.idProduto = idProduto;
    }

    public ProdutoModel() {
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ProdutosEnum getSetor() {
        return setor;
    }

    public void setSetor(ProdutosEnum secao) {
        this.setor = secao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
}
