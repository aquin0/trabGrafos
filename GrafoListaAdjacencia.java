import java.util.*;

public class GrafoListaAdjacencia {
    private boolean direcionado;
    private Map<Integer, List<Integer>> listaAdjacencia;

    public GrafoListaAdjacencia(int numeroVertices, boolean direcionado) {
        this.listaAdjacencia = new HashMap<>();
        for (int i = 0; i < numeroVertices; i++) {
            listaAdjacencia.put(i, new ArrayList<>());
        }
        this.direcionado = direcionado;
    }

    public void adicionarAresta(int origem, int destino) {
        listaAdjacencia.get(origem).add(destino);
        if (!direcionado) {
            listaAdjacencia.get(destino).add(origem);
        }
    }

    public void removerAresta(int origem, int destino) {
        listaAdjacencia.get(origem).remove(Integer.valueOf(destino));
        if (!direcionado) {
            listaAdjacencia.get(destino).remove(Integer.valueOf(origem));
        }
    }

    public List<Integer> obterVizinhos(int vertice) {
        return new ArrayList<>(listaAdjacencia.get(vertice));
    }

    public int obterGrau(int vertice) {
        int grau = listaAdjacencia.get(vertice).size();
        if (direcionado) {
            for (Map.Entry<Integer, List<Integer>> entrada : listaAdjacencia.entrySet()) {
                if (entrada.getValue().contains(vertice)) {
                    grau++;
                }
            }
        }
        return grau;
    }

    public boolean ehSimples() {
        for (int vertice : listaAdjacencia.keySet()) {
            List<Integer> adj = listaAdjacencia.get(vertice);
            if (adj.contains(vertice)) return false;
            if (adj.size() != new HashSet<>(adj).size()) return false;
        }
        return true;
    }

    public boolean ehRegular() {
        int grau = -1;
        for (List<Integer> adj : listaAdjacencia.values()) {
            if (grau == -1) grau = adj.size();
            else if (grau != adj.size()) return false;
        }
        return true;
    }

    public boolean ehCompleto() {
        int totalVertices = listaAdjacencia.keySet().size();
        for (List<Integer> adj : listaAdjacencia.values()) {
            if (adj.size() != totalVertices - 1) return false;
        }
        return true;
    }

    public boolean ehBipartido() {
        int[] cores = new int[listaAdjacencia.keySet().size()];
        Arrays.fill(cores, -1);

        for (int vertice : listaAdjacencia.keySet()) {
            if (cores[vertice] == -1) {
                if (!bfsBipartido(vertice, cores)) return false;
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

            for (int v : listaAdjacencia.get(u)) {
                if (cores[v] == -1) {
                    cores[v] = 1 - cores[u];
                    queue.add(v);
                } else if (cores[v] == cores[u]) {
                    return false;
                }
            }
        }
        return true;
    }


}