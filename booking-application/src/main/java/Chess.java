import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chess {
    Boolean isInRange(int x){
        return x >= 0 && x <= 7;
    }

    Boolean isOnBoard(String loc){
       return isInRange(loc.charAt(0) - 'a') && isInRange(loc.charAt(1) - '1');
    }

    String move1(char c, int delta){
        return Character.toString(c + delta);
    }

    String move(String loc, int dx, int dy){
        return move1(loc.charAt(0), dx) + move1(loc.charAt(1), dy);
    }

    List<Integer> deltas = Stream.of(1, 2)
            .flatMap(x -> Stream.of(-x, x))
            .toList();

    record rec(int x, int y){
    }

    List<String> moves(String loc) {
        return deltas
                .stream()
                .flatMap(dx -> deltas.stream()
                .map(dy -> new rec(dx, dy)))
                .filter(d -> Math.abs(d.x) != Math.abs(d.y))
                .map(d -> move(loc, d.x, d.y))
                .filter(pos -> isOnBoard(pos))
                .toList();
    }


}

