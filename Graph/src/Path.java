/**
 * @author Taochunwei
 * @date 2019/10/15 - 16:51
 */
import java.util.Vector;
import java.util.Stack;
public class Path {
    private Graph G;
    private int s;
    private boolean isvisted[];
    private int[] form;

    private void dfs(int s){
        isvisted[s]=true;
        for(int i:G.adj(s)){
            if(!isvisted[i]){
                form[i]=s;
                dfs(i);
            }
        }
    }

    public Path(Graph G,int s){
        this.G=G;
        this.s=s;

        isvisted=new boolean[G.V()];
        form=new int[G.V()];
        for (int i = 0; i <G.V() ; i++) {
            isvisted[i]=false;
            form[i]=-1;
        }

        dfs(s);
    }

    public boolean hasPath(int w){
        assert w>=0&&w<G.V();
        return isvisted[w];
    }

    public Vector<Integer> path(int w){
        assert hasPath(w);

        Stack<Integer> s=new Stack<Integer>();

        int p=w;
        while (p!=-1){
            s.push(p);
            p=form[p];
        }

        Vector<Integer> res= new Vector<>();

        while(!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }

    public void showPath(int w){
        assert hasPath(w);

        Vector<Integer> vec= path(w);
        for (int i = 0; i <vec.size() ; i++) {
            System.out.print(vec.elementAt(i));
            if(i==vec.size()-1)
                System.out.println();
            else System.out.print(" -> ");
        }
    }
}
