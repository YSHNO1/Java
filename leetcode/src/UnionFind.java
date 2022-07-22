public class UnionFind {
    int[] parent;
    int[] rank;  //用来记录每个树的深度，这样在合并的时候，就可以考虑za

    public UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;  //父节点都为自己
        }
    }

    public int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            //优化，在查询时进行路径压缩
            parent[x] = find(parent[x]); //将每个节点的父节点都直接设置为根节点
            return parent[x];   //一路向上找到根节点
        }
    }
    public void merge(int x, int y){
        int i = find(x);
        int j = find(y);  //先找各自的父节点
        if(i == j) return;
        parent[i] = j;
    }
}
