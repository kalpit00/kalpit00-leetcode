// Last updated: 11/22/2026, 7:31:32 PM
1class ProductOfNumbers {
2    List<Integer> prefixProduct = new ArrayList<>();
3    int size = 0;
4
5    public ProductOfNumbers() {
6        prefixProduct.add(1);
7    }
8    public void add(int num) {
9        if (num == 0) {
10            prefixProduct = new ArrayList<Integer>();
11            prefixProduct.add(1);
12            size = 0;
13        } else {
14            prefixProduct.add(prefixProduct.get(size) * num);
15            size++;
16        }
17    }
18
19    public int getProduct(int k) {
20        if (size < k) {
21            return 0;
22        }
23        return prefixProduct.get(size) / prefixProduct.get(size - k);
24    }
25}