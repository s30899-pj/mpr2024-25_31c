import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int a = 4;
        double b = 20;
        float c = 1.1f;
        char d = 'd';
        boolean e = true;

        Integer f = 10;
        String z = "chomiczki";
        Double x = 20.5;
        Float y = 30.5f;

        Student student1 = new Student();
        student1.setName("Mateusz");

        Student student2 = new Student();
        student2.setName("Pawel");

        if (e) {

            System.out.println("Student student1, name: " + student1.getName());
            System.out.println("Student student2, name: " + student2.getName());
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println(f);
        System.out.println(z);
        System.out.println(x);
        System.out.println(y);


        switch (z) {
            case "chomik":
                System.out.println("Student student1, name: " + student1.getName());
                break;
            case "Bartus":
                System.out.println("Student student2, name: " + student2.getName());
                break;
            default:
                System.out.println("default value");
        }
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);


        List<Integer> integerList2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
//        System.out.println(integerList2);
//        //      integerList.remove(3);
        //         integerList2.remove(3);

//       for (int i = 0; i < 10; i++) {
//        System.out.println(i);
//       }

//      for (Integer i : integerList) {
//      System.out.println(i);
//      }

//        integerList2.stream()
//             .forEach(i -> System.out.println(i));

// uwaga - niedokonczone      List<Integer> list = integerList2.stream()
//                              .map(integer -> multiplyInteger)
//                              .forEach(i -> System.out.println(i));

        Mercedes mercedes = new Mercedes();
//        mercedes.printName();
        mercedes.moveForward();

        try {
            mercedes.printName();
        } catch (MercedesException exception) {
            mercedes.moveForward();
        } catch (NumberFormatException exception) {
            System.out.println(exception.getMessage());
        }
    }
}