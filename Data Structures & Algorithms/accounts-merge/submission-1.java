class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Time: O(a*e + a*eloge) where a is the number of accounts and e is the number of emails on each account
        // Space: O(a*e)
        int numberOfEmails = 0;
        for(List<String> account : accounts) {
            numberOfEmails += account.size() - 1;
        }
        UnionFind unionFind = new UnionFind(numberOfEmails);

        Map<String, Integer> emailToIndexMap = new HashMap<>();
        Map<Integer, String> indexToName = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);

            indexToName.put(i, name);

            for(int j=1; j < account.size(); j++) {
                String email = account.get(j);
                if(emailToIndexMap.containsKey(email)) {
                    unionFind.union(i, emailToIndexMap.get(email));
                } else {
                    emailToIndexMap.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> rootIdToEmails = new HashMap<>();
        for(Map.Entry<String, Integer>  emailAndIndex : emailToIndexMap.entrySet()) {
            String email = emailAndIndex.getKey();
            int rootId = unionFind.find(emailAndIndex.getValue());
            
            if(!rootIdToEmails.containsKey(rootId)) {
                rootIdToEmails.put(rootId, new ArrayList<>());
            }
            rootIdToEmails.get(rootId).add(email);
        }


        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>>  idAndEmails : rootIdToEmails.entrySet()) {
            int rootId = idAndEmails.getKey();

            List<String> emails = idAndEmails.getValue();
            emails.sort((a,b) -> a.compareTo(b));

            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(indexToName.get(rootId));
            mergedAccount.addAll(emails);

            result.add(mergedAccount);
        }

        return result;
    }

    public class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        public boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if (parent1 == parent2) {
                return false;
            }

            if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1];
            } else {
                parent[parent2] = parent1;
                rank[parent1] += rank[parent2];
            }

            return true;
        }
    }
}