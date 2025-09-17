class Node {
    Processo processo;
    Node anterior;
    Node proximo;

    public Node(Processo processo) {
        this.processo = processo;
        this.anterior = null;
        this.proximo = null;
    }
}
