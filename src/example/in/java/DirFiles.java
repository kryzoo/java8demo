package example.in.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * $author Kryzoo (mpe@touk.pl)
 * Date: 03.04.13 23:23
 */

public class DirFiles {
    public static void main(String[] args) throws IOException {
            Files.newDirectoryStream(Paths.get("/home/kryzoo")).entries()
                    .filter(f -> Files.isDirectory(f))
                    .filter(DirFiles::isNotHidden)
                    .forEach(System.out::println);

    }

    private static boolean isNotHidden(Path name) {
        boolean res = false;
        try {
            res = !Files.isHidden(name);
        } catch (IOException e) {
            return false;
        }
        return res;
    }
}

