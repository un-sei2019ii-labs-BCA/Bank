import java.util.*;
 
public class Short3 {
    int[][] grafo;
    char[]  nodos;
 
    Short3(String serieNodos) {
        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }
 
  
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2]=distancia;
        grafo[n2][n1]=distancia;
    }
 
   
    private int posicionNodo(char nodo) {
        for(int i=0; i<nodos.length; i++) {
            if(nodos[i]==nodo) return i;
        }
        return -1;
    }
 
   
    public void encontrarRutaMinimaFuerzaBruta(char inicio, char fin) {
        int p1 = posicionNodo(inicio);
        int p2 = posicionNodo(fin);
       
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }
 
  
    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        
        if(nodoI==nodoF) {
            for(int x: resultado) System.out.print(nodos[x]+ " ");
            System.out.print(": " + evaluar(resultado));
            System.out.println();
            return;
        }
     
        List<Integer> lista = new Vector<Integer>();
        for(int i=0; i<grafo.length;i++) {
            if(grafo[nodoI][i]!=0 && !resultado.contains(i))lista.add(i);
        }
        
        for(int nodo: lista) {
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
    }
 
    
    public int evaluar(Stack<Integer> resultado) {
        int  resp = 0;
        int[]   r = new int[resultado.size()];
        int     i = 0;
        for(int x: resultado) r[i++]=x;
        for(i=1; i<r.length; i++) resp+=grafo[r[i]][r[i-1]];
        return resp;
    }
 
    public static void main(String[] args) {
        Short3 g = new Short3 ("abcdef");
        g.agregarRuta('a','b', 5);
        g.agregarRuta('a','e', 3);
        g.agregarRuta('b','e', 6);
        g.agregarRuta('b','f', 9);
        g.agregarRuta('b','c', 10);
        g.agregarRuta('c','d', 15);
        g.agregarRuta('c','f', 9);
        g.agregarRuta('d','e', 1);
        g.agregarRuta('d','f', 2);
        g.agregarRuta('e','f', 12);
        char inicio = 'a';
        char fin    = 'd';
        g.encontrarRutaMinimaFuerzaBruta(inicio, fin);
    }
}