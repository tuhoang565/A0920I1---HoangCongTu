package B10_DSA_List.BaiTap.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList listObject = new MyList();

        listObject.add(0, "loo");
        listObject.add(1, "lii");
        listObject.add(2, "laa");
        listObject.add(8, 1);
        listObject.add(1, "hello 1");


        System.out.println(listObject.toString());

    }
}
