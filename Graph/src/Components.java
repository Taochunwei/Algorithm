/**
 * @author Taochunwei
 * @date 2019/10/14 - 16:59
 */
public class Components {
    Graph G;
    private boolean isvisited[];
    private int ccount;
    private int[] id;

    private void dfs(int v){
        isvisited[v]=true;
        id[v]=ccount;
        for(int i:G.adj(v)){
            if(!isvisited[i]){
                dfs(i);
            }
        }
    }

    public Components(Graph G){
        this.G=G;
        int n=G.V();
        this.isvisited=new boolean[n];
        this.id=new int[n];
        ccount=0;
        for (int i = 0; i <n ; i++) {
            id[i]=-1;
            isvisited[i]=false;
        }

        for (int i = 0; i <n ; i++) {
            if(!isvisited[i]){
                ccount++;
                dfs(i);
            }
        }
    }

    public int count(){
        return ccount;
    }

    public boolean isConnected(int v,int w){
        assert v>=0&&v<G.V();
        assert w>=0&&w<G.V();

        return id[v]==id[w];
    }
}
