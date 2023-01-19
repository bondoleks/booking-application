
    public class Main {
        public static void main(String[] args) {
            System.out.println(isOverflowWhenAdd(Integer.MAX_VALUE, 3));
            System.out.println(isOverflowWhenSub(Integer.MIN_VALUE, -3));
            System.out.println(isOverflowWhenMul(Integer.MIN_VALUE, 3));
        }

        public static boolean isOverflowWhenAdd(int x, int y) {
            boolean result;
            return result = (x + y) > Integer.MAX_VALUE << 1;
        }

        public static boolean isOverflowWhenSub(int x, int y) {
            boolean result;
            return result = (x - y) > Integer.MIN_VALUE >> 1;
        }

        public static boolean isOverflowWhenMul(int x, int y) {
            boolean result;
            return result = (x * y) > Integer.MAX_VALUE << 1;
        }
    }
