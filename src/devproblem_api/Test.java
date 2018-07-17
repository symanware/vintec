package devproblem_api;

import java.util.HashMap;
import java.util.Map;

public class Test {

    static class T {
        int i;
        String s;

        T(int i, String s) {
            this.i = i;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            T t = (T) o;

            if (i != t.i) return false;
            return s != null ? s.equals(t.s) : t.s == null;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + (s != null ? s.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        Map<T, Double> map = new HashMap<>();
        T t1 = new T(10, "Y");
        map.put(t1, 10D);

        T t2 = new T(10, "Y");
        System.out.println(map.get(t2));

    }

}
