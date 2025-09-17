class ListaDeProcessos {
    Node cabeca;
    Node cauda;

    public ListaDeProcessos() {
        cabeca = null;
        cauda = null;
    }

    public void adicionar(Processo p) {
        Node novo = new Node(p);
        if (cabeca == null) {
            cabeca = cauda = novo;
        } else {
            cauda.proximo = novo;
            novo.anterior = cauda;
            cauda = novo;
        }
    }

    public Processo removerCabeca() {
        if (cabeca == null) return null;
        Processo p = cabeca.processo;
        cabeca = cabeca.proximo;
        if (cabeca != null) cabeca.anterior = null;
        else cauda = null;
        return p;
    }

    public boolean estaVazia() {
        return cabeca == null;
    }
}
