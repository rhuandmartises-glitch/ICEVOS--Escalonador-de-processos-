import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void carregarProcessosDeArquivo(String caminho, Scheduler scheduler) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean primeira = true;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;
                if (primeira && linha.toLowerCase().startsWith("id,")) {
                    primeira = false;
                    continue;
                }
                primeira = false;
                String[] partes = linha.split(",", -1);
                if (partes.length < 4) continue;
                try {
                    int id = Integer.parseInt(partes[0].trim());
                    String nome = partes[1].trim();
                    int prioridade = Integer.parseInt(partes[2].trim());
                    int ciclos = Integer.parseInt(partes[3].trim());
                    String recurso = null;
                    if (partes.length >= 5) {
                        recurso = partes[4].trim();
                        if (recurso.isEmpty()) recurso = null;
                    }
                    Processo p = new Processo(id, nome, prioridade, ciclos, recurso);
                    scheduler.adicionarProcesso(p);
                } catch (NumberFormatException ex) {
                    System.out.println("Erro em linha: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Falha ao ler arquivo: " + caminho);
        }
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        String arquivo = (args != null && args.length > 0) ? args[0] : "processos.csv";
        carregarProcessosDeArquivo(arquivo, scheduler);

        if (scheduler.listaAlta.estaVazia() && scheduler.listaMedia.estaVazia() && scheduler.listaBaixa.estaVazia()) {
            scheduler.adicionarProcesso(new Processo(1, "P1", 1, 4, null));
            scheduler.adicionarProcesso(new Processo(2, "P2", 1, 3, "DISCO"));
            scheduler.adicionarProcesso(new Processo(3, "P3", 2, 5, null));
            scheduler.adicionarProcesso(new Processo(4, "P4", 3, 6, null));
        }

        int ciclos = 25;
        for (int i = 0; i < ciclos; i++) {
            System.out.println("\n===== Ciclo " + (i + 1) + " =====");
            scheduler.executarCicloDeCPU();
        }
    }
            }
