/**
 * @author Taochunwei
 * @date 2019/10/14 - 10:48
 */
public interface Graph {
    public int V();//返回顶点个数
    public int E();
    public void addEdge(int v ,int w);
    void show();
    public Iterable<Integer> adj(int v);
}
