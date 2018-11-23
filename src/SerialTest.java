
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialTest {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/myObject.txt"));
        Person me = new Person("Alex", 28);
        out.writeObject(me);

    }
}
