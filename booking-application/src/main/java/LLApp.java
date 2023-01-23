public class LLApp {

  public static void main(String[] args) {

    XLinkedList ll = new XLinkedList();
    long len = ll.length();
    boolean contains5 = ll.containsTR(5);
    ll.addHead(1); // 1
    ll.addHead(5); // 5, 1
    ll.addHead(7); // 7, 5, 1
    ll.addAfter(11, x -> x == 5); // 7, 5, 11, 1
    System.out.println(ll);
  }

}
