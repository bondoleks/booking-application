public class XTreeApp {

  public static void main(String[] args) {
    XTree<Integer, Object> t = new XTree<>();

    t.putR2(50); // root
    t.putR2(40);
    t.putR2(30);
    t.putR2(70);
    t.putR2(80);
    t.putR2(900);
    t.putR2(60);
    t.putR2(10);

    System.out.println(t);
  }

}
