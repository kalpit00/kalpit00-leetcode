// Last updated: 7/27/2025, 1:33:10 AM
class Bitset {
    char[] arr;
    int zeroes, ones;
    boolean flag;

    public Bitset(int size) {
        arr = new char[size];
        Arrays.fill(arr, '0');
        zeroes = size;
        ones = 0;
        flag = true;
    }

    public void fix(int idx) {
        if (flag) {
            if (arr[idx] == '0') {
                arr[idx] = '1';
                ones++;
                zeroes--;
            }
        } else {
            if (arr[idx] == '1') {
                arr[idx] = '0';
                ones++;
                zeroes--;
            }
        }
    }

    public void unfix(int idx) {
        if (flag) {
            if (arr[idx] == '1') {
                arr[idx] = '0';
                ones--;
                zeroes++;
            }
        } else {
            if (arr[idx] == '0') {
                arr[idx] = '1';
                ones--;
                zeroes++;
            }
        }
    }

    public void flip() {
        flag = !flag;
        int temp = zeroes;
        zeroes = ones;
        ones = temp;
    }

    public boolean all() {
        return zeroes == 0;
    }

    public boolean one() {
        return ones > 0;
    }

    public int count() {
        return ones;
    }

    public String toString() {
        if (flag) return new String(arr);

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}
