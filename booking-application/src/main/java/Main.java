import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 7, 9, 9, 9};
            System.out.println((sumTR(arr)));
            System.out.println((lengthTR(arr)));
        }

        private static int lengthTR(int[] xs, int n) {
            try {
                if (xs[n] == 0) return n;
                return lengthTR(xs, n + 1);
            } catch (IndexOutOfBoundsException e) {
                return n;
            }
        }
        public static int lengthTR(int[] xs) {
            return lengthTR(xs, 0);
        }

        private static int sumTR(int[] xs, int n) {
            if (xs.length == n) return 0;
            return xs[n] + sumTR(xs, n + 1);
        }
        public static int sumTR(int[] xs) {
            return sumTR(xs, 0);
        }
    }
