/**
 * @author Taochunwei
 * @date 2019/10/16 - 10:03
 */
import java.util.Vector;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class ShortestPath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    public ShortestPath(Graph G,int s){
        this.G=G;
        assert s>=9&&s<=G.V();

        this.s=s;
        visited=new boolean[G.V()];
        from=new int[G.V()];
        ord=new int[G.V()];
        for (int i = 0; i <G.V() ; i++) {
            visited[i]=false;
            from[i]=-1;
            ord[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited[s]=true;
        ord[s]=0;
        while (!q.isEmpty()) {
            int v=q.remove();
            for(int i:G.adj(v)){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;
                    from[i]=v;
                    ord[i]=ord[v]+1;
                }
            }
        }
    }

    public boolean hasPath(int w){
        assert w>=0&&w<G.V();
        return visited[w];
    }

    private int length(int w){
        assert w>=0&&w<G.V();
        return ord[w];
    }

    private Vector<Integer> path(int w){
        assert hasPath(w);

        Stack<Integer> s=new Stack<>();
        int p=w;
        while(p!=-1){
            s.push(p);
            p=from[p];
        }
        Vector<Integer> res=new Vector<>();
        while (!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }

    public void showPath(int w){
        assert hasPath(w);
        Vector<Integer> path=path(w);
        for (int i = 0; i <path.size() ; i++) {
            System.out.print(path.elementAt(i));
            if(i!=path.size()-1)
                System.out.print(" -> ");
            else System.out.println();
        }
    }
}
