import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by maxim on 25.09.14.
 */
public class PathDemo2 {

    public static void main(String[] args) throws URISyntaxException {
        URL url = PathDemo2.class.getResource("");
        System.out.printf("\n%s\n", url);

        // Create path for this compiled class
        Path path = Paths.get(PathDemo2.class.getResource("").getFile());
        System.out.println(path);

        // Create path for current dir
        Path path2 = Paths.get("");
        System.out.println(path2);
        System.out.println(path2.toAbsolutePath());
        System.out.println(System.getProperty("user.dir"));

        Path pathFile = Paths.get("ch9/sec02/PathDemo2");
        System.out.println(pathFile);
        System.out.println(pathFile.toAbsolutePath());

        // Absolute and relative path
        Path absolute = Paths.get("/", "Users", "maxim");
        System.out.printf("\nAbsolute path: %s\n", absolute);
        Path relative = Paths.get("java8-impatient-book", "ch9", "readme.txt");
        System.out.printf("Relative path: %s\n", relative);

        Path homeDirectory = Paths.get("/Users/maxim");
        System.out.println(homeDirectory);
        Path readmePath = homeDirectory.resolve("dev/jprojects/java8-impatient-book/readme.txt");
        System.out.println(readmePath);
        Path workPath = Paths.get("/home/cay/myprog/work");
        Path tempPath = workPath.resolveSibling("temp");
        System.out.println(tempPath);

        Path p = Paths.get("/home", "cay", "myprog.properties");
        System.out.printf("Path: %s; parent: %s; file: %s\n", p, p.getParent(), p.getFileName());
        System.out.printf("Root path: %s; root file: %s\n", p.getRoot(), p.getFileName().getRoot());
        System.out.println(p.getFileSystem());

        System.out.println("\nIterate by path " + workPath);
        for (Path path1 : workPath) {
            System.out.println(path1);
        }

        System.out.println("\nForeach lambda for path " + workPath);
        workPath.forEach(System.out::println);
    }
}
