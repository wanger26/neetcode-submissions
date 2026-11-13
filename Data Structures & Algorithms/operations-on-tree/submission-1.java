class LockingTree {

    private final int n;
    private final int[] lockOwner;
    private final int[] parent;
    private final List<Integer>[] children;

    public LockingTree(int[] parent) {
        this.n = parent.length;

        this.lockOwner = new int[n];
        this.parent = parent;
        this.children = new List[n];
        for(int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            int parentNode = parent[i];
            if (parentNode != -1) {
                this.children[parentNode].add(i);
            }
        }
    }
    
    public boolean lock(int num, int user) {
        if(lockOwner[num] == 0) {
            lockOwner[num] = user;
            return true;
        }

        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(lockOwner[num] == user) {
            lockOwner[num] = 0;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(lockOwner[num] != 0) {
            return false;
        }

        int currentNode = num;
        while(currentNode != -1) {
            if(lockOwner[currentNode] != 0) {
                return false;
            }
            currentNode = parent[currentNode];
        }

        List<Integer> toLock = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(lockOwner[node] != 0) {
                toLock.add(node);
            }

            for(int child : children[node]) {
                queue.add(child);
            }
        }

        if(toLock.isEmpty()) {
            return false;
        }

        for(int node : toLock) {
            lockOwner[node] = 0;
        }
        lockOwner[num] = user;

        return true;
    }
}
