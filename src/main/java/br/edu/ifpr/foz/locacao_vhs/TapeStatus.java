package br.edu.ifpr.foz.locacao_vhs;

  public enum TapeStatus {
    DISPONIVEL("Disponível"),
    EMPRESTADA("Emprestada"),
    INDISPONIVEL("Indisponível"),
    ALUGADO("Alugado");


    private final String descricao;

    TapeStatus(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
