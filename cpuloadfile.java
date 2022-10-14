import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class cpuloadfile {
  boolean logFileDirCreated = false;
  boolean logFileCreated = false;

  public String CPUfile() throws InterruptedIOException {
    String conf = "";
    if (this.logFileCreated == false) {
      try {
        Path logFilePath = Path.of("logs/CPULOG.txt");
        if (logFilePath.toFile().exists()) {
          return "";
        }
        Files.createDirectory(logFilePath);
        File log = new File("logs/CPULOG.txt");
        if (createLogFile(logFilePath.toString())) {
          System.out.println("File created: " + log.getName());
          conf = "File created:  " + log.getName();
          this.logFileCreated = true;
          this.logFileDirCreated = true;
        } else {
          System.out.println("File already exists.");
          conf = "File already exists";
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        System.exit(1);
      }
    }
    return conf;
  }

  private Boolean createLogFile(String logFilePathString) throws IOException {

    String directoryPathString = logFilePathString.split("/")[0];
    Path logDirectoryPath = Path.of(directoryPathString);
    String fileNameString = logFilePathString.split("/")[1];
    Path logFilePath = Path.of(directoryPathString, fileNameString);
    try {
      if (createDirectory(logDirectoryPath) && createFile(logFilePath)) {
        this.logFileCreated = true;
        this.logFileDirCreated = true;
        return true;
      } else {
        return false;
      }
    } catch (IOException e) {
      if (e.getCause() != null && e.getCause() instanceof FileAlreadyExistsException)
        return true;

      System.out.println("An error occurred.");
      e.printStackTrace();
      System.exit(1);
      return false;
    }
  }

  private Boolean createDirectory(Path dirPath) throws InterruptedIOException {
    try {
      Files.createDirectory(dirPath);
      return true;
    } catch (FileAlreadyExistsException e) {
      return true;
    } catch (IOException e) {
      if (e.getCause() != null && e.getCause() instanceof FileAlreadyExistsException)
        return true;
      System.out.println("An error occurred creating dir.");
      e.printStackTrace();
      System.exit(1);
      return false;
    }
  }

  private Boolean createFile(Path filePath) throws InterruptedIOException {
    try {
      Files.createFile(filePath);
      return true;
    } catch (FileAlreadyExistsException e) {
      return true;
    } catch (IOException e) {
      System.out.println("An error occurred creating file.");
      e.printStackTrace();
      return false;
    }
  }
}