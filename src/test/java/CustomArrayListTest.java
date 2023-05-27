import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class CustomArrayListTest {

 public static CustomArrayList<String> customArrayList;

   @BeforeAll
   public static void init() {
        customArrayList = new CustomArrayList<>();
   }

   @AfterEach
   public void clearingAfterEach() {
        customArrayList.clear();
  }

    @Test
    public void add() {
         customArrayList.add("Alexandr");
         customArrayList.add("Vasiliy");
         customArrayList.add("Grigoriy");

        Assertions.assertEquals(3, customArrayList.size());
        Assertions.assertEquals("Alexandr", customArrayList.get(0));
        Assertions.assertEquals("Grigoriy", customArrayList.get(2));

    }

    @Test
    public void addInSpecifiedPosition() {
      customArrayList.add("Alexandr");
      customArrayList.add("Vasiliy");
      customArrayList.add("Grigoriy");

      customArrayList.add(1, "Viktor");
      customArrayList.add(3, "Alexey");

      Assertions.assertEquals("Viktor", customArrayList.get(1));
      Assertions.assertEquals("Alexey", customArrayList.get(3));
      Assertions.assertEquals(5, customArrayList.size());

    }

    @Test
    public void get() {
      customArrayList.add("Alexandr");
      customArrayList.add("Vasiliy");
      customArrayList.add("Grigoriy");

      Assertions.assertEquals("Alexandr", customArrayList.get(0));
      Assertions.assertEquals("Vasiliy", customArrayList.get(1));
      Assertions.assertEquals("Grigoriy", customArrayList.get(2));


    }

    @Test
    public void indexOf() {
        customArrayList.add("Alexandr");
        customArrayList.add("Vasiliy");
        customArrayList.add("Grigoriy");

        Assertions.assertEquals(0, customArrayList.indexOf("Alexandr"));
        Assertions.assertEquals(2, customArrayList.indexOf("Grigoriy"));
    }

    @Test
    public void removeElementInSpecifiedPosition() {
      customArrayList.add("Alexandr");
      customArrayList.add("Vasiliy");
      customArrayList.add("Grigoriy");

      customArrayList.remove(1);

      Assertions.assertEquals(2, customArrayList.size());
      Assertions.assertEquals("Grigoriy", customArrayList.get(1));
      Assertions.assertEquals(-1, customArrayList.indexOf("Vasiliy"));

    }

    @Test
    public void removeElement() {
      customArrayList.add("Alexandr");
      customArrayList.add("Vasiliy");
      customArrayList.add("Grigoriy");

      customArrayList.remove("Alexandr");

      Assertions.assertEquals(2, customArrayList.size());
      Assertions.assertEquals("Vasiliy", customArrayList.get(0));
      Assertions.assertEquals(-1, customArrayList.indexOf("Alexandr"));

    }

    @Test
    public void clear() {
      customArrayList.add("Alexandr");
      customArrayList.add("Vasiliy");
      customArrayList.add("Grigoriy");

      customArrayList.clear();

      Assertions.assertEquals(0, customArrayList.size());
      Assertions.assertNull(customArrayList.get(0));
      Assertions.assertNull(customArrayList.get(1));
    }

    @Test
    public void sort() {
      customArrayList.add("Grigoriy");
      customArrayList.add("Alexandr");
      customArrayList.add("Vasiliy");
      customArrayList.add("Pavel");

      customArrayList.sort(String::compareTo);

      Assertions.assertEquals("Alexandr", customArrayList.get(0));
      Assertions.assertEquals("Grigoriy", customArrayList.get(1));
      Assertions.assertEquals("Pavel", customArrayList.get(2));
      Assertions.assertEquals("Vasiliy", customArrayList.get(3));
    }

    @Test
    public void set() {
      customArrayList.add("Alexandr");
      customArrayList.add("Vasiliy");
      customArrayList.add("Grigoriy");

      customArrayList.set(1, "Viktor");
      customArrayList.set(2, "Pavel");

      Assertions.assertEquals("Viktor", customArrayList.get(1));
      Assertions.assertEquals("Pavel", customArrayList.get(2));
      Assertions.assertEquals(-1, customArrayList.indexOf("Vasiliy"));
      Assertions.assertEquals(-1, customArrayList.indexOf("Grigoriy"));

    }

    @Test
    public void size() {
     Assertions.assertEquals(0, customArrayList.size());

      customArrayList.add("Alexandr");

      Assertions.assertEquals(1, customArrayList.size());

      customArrayList.add("Vasiliy");

      Assertions.assertEquals(2, customArrayList.size());

      customArrayList.remove(0);

      Assertions.assertEquals(1, customArrayList.size());

      customArrayList.clear();

      Assertions.assertEquals(0, customArrayList.size());

    }

}
