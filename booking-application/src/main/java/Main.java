import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(func(2)));
        System.out.println(toBinary3(3));
    }

    public static String[] func(int n) {
        String[] res = new String[n * n];
        StringBuilder st = new StringBuilder();
        int ind = 0;
        String z = "0";
        String o = "1";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    for (int k = 0; k < n - 1; k++) {
                        st.append(z);
                    }
                    if (j % 2 == 0) {
                        st.append(z);
                    } else {
                        st.append(o);
                    }
                } else {
                    for (int k = 0; k < n - 1; k++) {
                        st.append(o);
                    }
                    if (j % 2 == 0) {
                        st.append(z);
                    } else {
                        st.append(o);
                    }
                }
                res[ind] = String.valueOf(st);
                st.delete(0, n);
                ind++;
            }
        }
        return res;
    }

    public static String toBinary3(int n) {
        StringBuilder outcome = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) { // bit number
            int bitValue = 1 << i;
            int bit = n & bitValue;
            outcome.append(bit > 0 ? "1" : "0");
        }
        return outcome.toString();
    }
}