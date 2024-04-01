import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a representação do grafo:");
        System.out.println("1. Matriz de Adjacência");
        System.out.println("2. Lista de Adjacência");
        int escolha = scanner.nextInt();

        System.out.println("Digite o número de vértices do grafo:");
        int numeroVertices = scanner.nextInt();

        System.out.println("O grafo é direcionado? (true/false):");
        boolean direcionado = scanner.nextBoolean();

        if (escolha == 1) {
            GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia(numeroVertices, direcionado);
            // Continuar com as opções para manipular o grafo
            manipularGrafoMatriz(grafo, scanner);
        } else if (escolha == 2) {
            GrafoListaAdjacencia grafo = new GrafoListaAdjacencia(numeroVertices, direcionado);
            // Continuar com as opções para manipular o grafo
            manipularGrafoLista(grafo, scanner);
        }
    }

    private static void manipularGrafoMatriz(GrafoMatrizAdjacencia grafo, Scanner scanner) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma operação para o grafo de Matriz de Adjacência:");
            System.out.println("1. Adicionar aresta");
            System.out.println("2. Remover aresta");
            System.out.println("3. Verificar se é simples");
            System.out.println("4. Verificar se é regular");
            System.out.println("5. Verificar se é completo");
            System.out.println("6. Verificar se é bipartido");
            System.out.println("7. Obter vizinhos de um vértice");
            System.out.println("8. Obter grau de um vértice");
            System.out.println("9. Sair");
            int escolha = scanner.nextInt();

            int origem, destino, vertice;
            switch (escolha) {
                case 1:
                    System.out.println("Origem:");
                    origem = scanner.nextInt();
                    System.out.println("Destino:");
                    destino = scanner.nextInt();
                    grafo.adicionarAresta(origem, destino);
                    System.out.println("Aresta adicionada com sucesso.");
                    break;
                case 2:
                    System.out.println("Origem:");
                    origem = scanner.nextInt();
                    System.out.println("Destino:");
                    destino = scanner.nextInt();
                    grafo.removerAresta(origem, destino);
                    System.out.println("Aresta removida com sucesso.");
                    break;
                case 3:
                    System.out.println("O grafo é simples? " + grafo.ehSimples());
                    break;
                case 4:
                    System.out.println("O grafo é regular? " + grafo.ehRegular());
                    break;
                case 5:
                    System.out.println("O grafo é completo? " + grafo.ehCompleto());
                    break;
                case 6:
                    System.out.println("O grafo é bipartido? " + grafo.ehBipartido());
                    break;
                case 7:
                    System.out.println("Digite o vértice para obter seus vizinhos:");
                    vertice = scanner.nextInt();
                    System.out.println("Vizinhos: " + grafo.obterVizinhos(vertice));
                    break;
                case 8:
                    System.out.println("Digite o vértice para obter seu grau:");
                    vertice = scanner.nextInt();
                    System.out.println("Grau do vértice: " + grafo.obterGrau(vertice));
                    break;
                case 9:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void manipularGrafoLista(GrafoListaAdjacencia grafo, Scanner scanner) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma operação para o grafo de Lista de Adjacência:");
            System.out.println("1. Adicionar aresta");
            System.out.println("2. Remover aresta");
            System.out.println("3. Verificar se é simples");
            System.out.println("4. Verificar se é regular");
            System.out.println("5. Verificar se é completo");
            System.out.println("6. Verificar se é bipartido");
            System.out.println("7. Obter vizinhos de um vértice");
            System.out.println("8. Obter grau de um vértice");
            System.out.println("9. Sair");
            int escolha = scanner.nextInt();

            int origem, destino, vertice;
            switch (escolha) {
                case 1:
                    System.out.println("Origem:");
                    origem = scanner.nextInt();
                    System.out.println("Destino:");
                    destino = scanner.nextInt();
                    grafo.adicionarAresta(origem, destino);
                    System.out.println("Aresta adicionada.");
                    break;
                case 2:
                    System.out.println("Origem:");
                    origem = scanner.nextInt();
                    System.out.println("Destino:");
                    destino = scanner.nextInt();
                    grafo.removerAresta(origem, destino);
                    System.out.println("Aresta removida.");
                    break;
                case 3:
                    System.out.println("O grafo é simples? " + grafo.ehSimples());
                    break;
                case 4:
                    System.out.println("O grafo é regular? " + grafo.ehRegular());
                    break;
                case 5:
                    System.out.println("O grafo é completo? " + grafo.ehCompleto());
                    break;
                case 6:
                    System.out.println("O grafo é bipartido? " + grafo.ehBipartido());
                    break;
                case 7:
                    System.out.println("Digite o vértice para obter seus vizinhos:");
                    vertice = scanner.nextInt();
                    System.out.println("Vizinhos: " + grafo.obterVizinhos(vertice));
                    break;
                case 8:
                    System.out.println("Digite o vértice para obter seu grau:");
                    vertice = scanner.nextInt();
                    System.out.println("Grau: " + grafo.obterGrau(vertice));
                    break;
                case 9:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}