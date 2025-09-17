public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        Processo p1 = new Processo(1, "P1", 1, 4, null);
        Processo p2 = new Processo(2, "P2", 1, 3, "DISCO");
        Processo p3 = new Processo(3, "P3", 2, 5, null);
        Processo p4 = new Processo(4, "P4", 3, 6, null);

        scheduler.adicionarProcesso(p1);
        scheduler.adicionarProcesso(p2);
        scheduler.adicionarProcesso(p3);
        scheduler.adicionarProcesso(p4);

        for (int i = 0; i < 20; i++) {
            System.out.println("\n--- Ciclo " + (i+1) + " ---");
            scheduler.executarCicloDeCPU();
        }
    }
}
