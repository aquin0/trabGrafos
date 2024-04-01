import java.util.*;

public class GrafoMatrizAdjacencia {
    private boolean direcionado;
    private int[][] matrizAdjacencia;

    public GrafoMatrizAdjacencia(int numeroVertices, boolean direcionado) {
        this.matrizAdjacencia = new int[numeroVertices][numeroVertices];
        this.direcionado = direcionado;
    }

    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 1;
        if (!direcionado) {
            matrizAdjacencia[destino][origem] = 1;
        }
    }

    public void removerAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 0;
        if (!direcionado) {
            matrizAdjacencia[destino][origem] = 0;
        }
    }

    public List<Integer> obterVizinhos(int vertice) {
        List<Integer> vizinhos = new ArrayList<>();
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (matrizAdjacencia[vertice][i] == 1) {
                vizinhos.add(i);
            }
        }
        return vizinhos;
    }

    public int obterGrau(int vertice) {
        int grau = 0;
        for (int destino = 0; destino < matrizAdjacencia.length; destino++) {
            if (matrizAdjacencia[vertice][destino] == 1) {
                grau++;
            }
            if (!direcionado && matrizAdjacencia[destino][vertice] == 1) {
                grau++;
            }
        }
        return grau;
    }

    public boolean ehSimples() {
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (matrizAdjacencia[i][i] != 0) return false; 
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (i != j && matrizAdjacencia[i][j] > 1) return false;
            }
        }
        return true;
    }

    public boolean ehRegular() {
        int grauInicial = obterGrau(0);
        for (int i = 1; i < matrizAdjacencia.length; i++) {
            if (obterGrau(i) != grauInicial) return false;
        }
        return true;
    }

    public boolean ehCompleto() {
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (i != j && matrizAdjacencia[i][j] == 0) return false;
            }
        }
        return true;
    }

    public boolean ehBipartido() {
        int[] cores = new int[matrizAdjacencia.length];
        Arrays.fill(cores, -1);

        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (cores[i] == -1) {
                if (!bfsBipartido(i, cores)) return false;
            }
        }
        return true;
    }

    private boolean bfsBipartido(int inicio, int[] cores) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(inicio);
        cores[inicio] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < matrizAdjacencia.length; v++) {
                if (matrizAdjacencia[u][v] == 1 && cores[v] == -1) {
                    cores[v] = 1 - cores[u];
                    queue.add(v);
                } else if (matrizAdjacencia[u][v] == 1 && cores[v] == cores[u]) {
                    return false;
                }
            }
        }
        return true;
    }

}