import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by maxim on 25.09.14.
 */
public class FilesDemo2 {

   public static void main(String[] args) throws IOException {
      Path path = Paths.get("ch9/sec02/FilesDemo.java");
      byte[] bytes = Files.readAllBytes(path);
      String content = new String(bytes, StandardCharsets.UTF_8);
      System.out.println(content.substring(0, 250) + "...");
      List<String> lines = Files.readAllLines(path);
      System.out.println("Last line: " + lines.get(lines.size() - 1));
   }
}
