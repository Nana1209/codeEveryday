public class UnionFind {
    private int[] parent;//保存每个元素的父节点
    /**
     * 以 i 为根结点的子树的高度（引入了路径压缩以后该定义并不准确）
     * 记录每个根节点对应的树的深度（如果不是根节点，其rank相当于以它作为根节点的子树的深度）。一开始，把所有元素的rank（秩）设为1。
     */
    private int[] rank;

    public int[] getParent() {
        return parent;
    }

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }
    public UnionFind(int[] p) {
        this.parent = p;
        this.rank = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            this.rank[i] = 1;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }

        //合并时比较两个根节点，把rank较小者往较大者上合并。
        if (rank[rootX] == rank[rootY]) {
            parent[rootX] = rootY;
            // 此时以 rootY 为根结点的树的高度仅加了 1
            rank[rootY]++;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            // 此时以 rootY 为根结点的树的高度不变
        } else {
            // 同理，此时以 rootX 为根结点的树的高度不变
            parent[rootY] = rootX;
        }
    }

    public int find(int x) {
        //寻父路径压缩
        //在查询的过程中，把沿途的每个节点的父节点都设为根节点即可。下一次再查询时，我们就可以省很多事
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean connected(int x,int y){
        return find(x)==find(y);
    }

}
