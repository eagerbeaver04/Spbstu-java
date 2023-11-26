package Classes.iostream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileUtility
{

    public static String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1)
            return "";
        else
            return filename.substring(lastDotIndex + 1);

    }

    public static String getBaseFilename(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1)
            return filename;
        else
            return filename.substring(0, lastDotIndex);
    }

    public static long getFileSizeNIO(String fileName) throws IOException
    {
        Path path = Paths.get(fileName);
        return Files.size(path);
    }

    public static String getOutputFileName(String filename, String extension)
    {
        File inputFile = new File(filename);
        String currentExtension = extension;
        if(Objects.equals(extension, ""))
            currentExtension = "ark";
        if (inputFile.getParent() != null)
            return inputFile.getParent() + File.separator + FileUtility.getBaseFilename(inputFile.getName()) + "." + currentExtension;
        else
            return FileUtility.getBaseFilename(inputFile.getName()) + "." + currentExtension;
    }
}
