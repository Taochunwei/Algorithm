/**
 * @author Taochunwei
 * @date 2019/10/13 - 10:48
 */
import java.util.Vector;
public class SparseGraph implements Graph {
    private int n,m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph( int n , boolean directed ){
        assert n >= 0;
        this.n = n;
        this.m = 0;    // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        this.g=(Vector<Integer>[]) new Vector[n];
        for (int i = 0; i <n ; i++) {
            g[i]=new Vector<Integer>();
        }
    }

    public int V(){
        return n;
    }
    public int E(){
        return m;
    }

    public void addEdge(int v,int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        g[v].add(w);

        if(v!=w&&!directed)
            g[w].add(v);

        m++;
    }

    public void show(){
        for (int i = 0; i <n ; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j <g[i].size() ; j++) {
                System.out.print(g[i].elementAt(j)+"\t");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int v,int w){
        assert v>=0&&v<n;
        assert w>=0&&w<n;

        for (int i = 0; i <g[v].size() ; i++) {
            if(g[v].elementAt(i)==w)
                return true;
        }
        return false;
    }

    public Iterable<Integer> adj(int v){
        assert v>=0&&v<n;
        return g[v];
    }
}
