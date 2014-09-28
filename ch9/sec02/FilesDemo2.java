import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/**
 * Created by maxim on 25.09.14.
 */
public class FilesDemo2 {

    public static void main(String[] args) throws IOException {
        // read file test

        Path path = Paths.get("ch9/sec02/FilesDemo.java");
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(content.substring(0, 250) + "...");
        List<String> lines = Files.readAllLines(path);
        System.out.println("Last line: " + lines.get(lines.size() - 1));

        Path testDir = Paths.get("ch9/test");
        List<String> lines2 = Files.readAllLines(testDir.resolve("conf.properties"));
        lines2.stream().forEach(System.out::println);

        // create directories

        Path tempDir = Paths.get("ch9/temp");
        if (!Files.exists(tempDir)) {
            Files.createDirectory(tempDir);
        }

        Path dirs = tempDir.resolve("dir1/dir2/dir3");
        if (!Files.exists(dirs)) {
            Files.createDirectories(dirs);
        }

        // write file test

        path = tempDir.resolve("FilesDemo.txt");
        content = content.replaceAll("e", "x");
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        path = tempDir.resolve("FilesDemo2.txt");
        Files.write(path, lines);
        Collections.reverse(lines);
        Files.write(path, lines, StandardOpenOption.APPEND);

        // copy files

        Path copyFile = tempDir.resolve("conf.copy");
        if (Files.exists(copyFile)) {
            Files.delete(copyFile);
        } else {
            Files.copy(testDir.resolve("conf.properties"), copyFile);
        }
    }
}
