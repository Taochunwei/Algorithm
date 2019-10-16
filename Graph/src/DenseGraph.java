/**
 * @author Taochunwei
 * @date 2019/10/13 - 10:47
 */
import java.util.Vector;
public class DenseGraph implements Graph {
    private int n,m;//n 是顶点数，m是边数
    boolean directed;
    boolean[][] g;

    public DenseGraph(int n,boolean directed){
        this.n=n;
        this.m=0;
        this.directed=directed;
        g=new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                g[i][j]=false;
            }
        }
    }

    public int V(){
        return n;
    }
    public int E(){
        return m;
    }
    public void addEdge(int v,int w){
        if(hasEdge(v,w))
            return;
        g[v][w]=true;
        if(!directed)
            g[w][v]=true;
        m++;
    }

    public boolean hasEdge(int v,int w){
        return g[v][w];
    }

    public void show(){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(g[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public Iterable<Integer> adj(int v){
        assert v>=0&&v<n;
        Vector<Integer> adjV=new Vector<Integer>();
        for (int i = 0; i <n ; i++) {
            if(g[v][i])
                adjV.add(i);
        }
        return adjV;
    }

}
