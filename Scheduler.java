class Scheduler {
    ListaDeProcessos listaAlta;
    ListaDeProcessos listaMedia;
    ListaDeProcessos listaBaixa;
    ListaDeProcessos listaBloqueados;
    int contadorAlta;

    public Scheduler() {
        listaAlta = new ListaDeProcessos();
        listaMedia = new ListaDeProcessos();
        listaBaixa = new ListaDeProcessos();
        listaBloqueados = new ListaDeProcessos();
        contadorAlta = 0;
    }

    public void adicionarProcesso(Processo p) {
        if (p.prioridade == 1) listaAlta.adicionar(p);
        else if (p.prioridade == 2) listaMedia.adicionar(p);
        else listaBaixa.adicionar(p);
    }

    public void executarCicloDeCPU() {
        if (!listaBloqueados.estaVazia()) {
            Processo desbloqueado = listaBloqueados.removerCabeca();
            adicionarProcesso(desbloqueado);
            System.out.println("Desbloqueado: " + desbloqueado.nome);
        }

        Processo atual = null;

        if (contadorAlta >= 5) {
            if (!listaMedia.estaVazia()) {
                atual = listaMedia.removerCabeca();
            } else if (!listaBaixa.estaVazia()) {
                atual = listaBaixa.removerCabeca();
            }
            contadorAlta = 0;
            } else {
            if (!listaAlta.estaVazia()) {
                atual = listaAlta.removerCabeca();
                contadorAlta++;
            } else if (!listaMedia.estaVazia()) {
                atual = listaMedia.removerCabeca();
                contadorAlta = 0;
            } else if (!listaBaixa.estaVazia()) {
                atual = listaBaixa.removerCabeca();
                contadorAlta = 0;
            }
        }

        if (atual == null) {
            System.out.println("Nenhum processo para executar.");
            return;
        }
        if ("DISCO".equals(atual.recursoNecessario) && !atual.jaBloqueado) {
            atual.jaBloqueado = true;
            listaBloqueados.adicionar(atual);
            System.out.println("Processo " + atual.nome + " bloqueado (DISCO).");
            return;
        }

        atual.ciclosNecessarios--;
        System.out.println("Executando: " + atual.nome + " (Restam " + atual.ciclosNecessarios + " ciclos)");

        if (atual.ciclosNecessarios > 0) {
            adicionarProcesso(atual);
        } else {
            System.out.println("Processo " + atual.nome + " finalizado.");
        }
    }
}
