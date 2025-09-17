        public class Scheduler {
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

    private void imprimirEstado() {
        System.out.println("Filas:");
        System.out.println("  Alta  : " + listaAlta.listarElementos());
        System.out.println("  Media : " + listaMedia.listarElementos());
        System.out.println("  Baixa : " + listaBaixa.listarElementos());
        System.out.println("  Bloq. : " + listaBloqueados.listarElementos());
    }

    public void executarCicloDeCPU() {
        if (!listaBloqueados.estaVazia()) {
            Processo desbloqueado = listaBloqueados.removerCabeca();
            desbloqueado.jaBloqueado = false;
            adicionarProcesso(desbloqueado);
            System.out.println("Evento: Desbloqueado -> " + desbloqueado);
        }

        imprimirEstado();

        Processo atual = null;

        if (contadorAlta >= 5) {
            if (!listaMedia.estaVazia()) {
                atual = listaMedia.removerCabeca();
                System.out.println("Regra anti-inanição: escolhida da média.");
            } else if (!listaBaixa.estaVazia()) {
                atual = listaBaixa.removerCabeca();
                System.out.println("Regra anti-inanição: escolhida da baixa.");
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
            System.out.println("Nenhum processo para executar neste ciclo.");
            return;
        }

        if ("DISCO".equals(atual.recursoNecessario) && !atual.jaBloqueado) {
            atual.jaBloqueado = true;
            listaBloqueados.adicionar(atual);
            System.out.println("Evento: Processo bloqueado por recurso DISCO -> " + atual);
            return;
        }

        System.out.println("Executando: " + atual);
        atual.ciclosNecessarios--;

        if (atual.ciclosNecessarios <= 0) {
            System.out.println("Evento: Processo finalizado -> " + atual.nome);
        } else {
            adicionarProcesso(atual);
        }
    }
        }
