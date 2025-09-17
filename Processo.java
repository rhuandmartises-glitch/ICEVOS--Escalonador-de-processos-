class Processo {
    int id;
    String nome;
    int prioridade; // 1 = Alta, 2 = Média, 3 = Baixa
    int ciclosNecessarios;
    String recursoNecessario;
    boolean jaBloqueado;

    public Processo(int id, String nome, int prioridade, int ciclosNecessarios, String recursoNecessario) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclosNecessarios = ciclosNecessarios;
        this.recursoNecessario = recursoNecessario;
        this.jaBloqueado = false;
    }
    
    @Override
    public String toString() {
        return "[" + id + "-" + nome + "-P" + prioridade + "-C:" + ciclosNecessarios +
               (recursoNecessario != null && !recursoNecessario.isEmpty() ? "-R:" + recursoNecessario : "") +
               (jaBloqueado ? "-BLOQ" : "") + "]";
    }
}
