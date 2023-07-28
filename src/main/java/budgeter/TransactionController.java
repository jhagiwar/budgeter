//package budgeter;
//
//import com.mysql.cj.xdevapi.JsonString;
//import spark.Request;
//
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.ServletException;
//import javax.servlet.http.Part;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//
//import static spark.Spark.*;
//
//
//public class TransactionController {
//
//    public static void main() {
//
//        File storageDir = new File("storage");
//        if (!storageDir.isDirectory()) storageDir.mkdir();
//
//        post("/incomplete-transactions", (req, res) -> uploadIncompTransactions(req));
//        get("/download/:file", (req, res) -> downloadFile(req.params(":file")));
//        get("/count", (req, res) -> countFiles());
//        delete("/delete/:file", (req, res) -> deleteFile(req.params(":file")));
//    }
//
//    private static String uploadIncompTransactions(Request request) {
//        // TO allow for multipart file uploads
//        try {
//            //Creating a JSONObject object
//            ObjectMapper mapper = new ObjectMapper();
//
//
//        } catch (Exception e) {
//            return "Exception occurred while uploading transactions" + e.getMessage();
//        }
//        return "incomplete transactions successfully uploaded";
//    }
//
//    private static String downloadFile(String fileName) {
//        Path filePath = Paths.get("storage").resolve(fileName);
//        File file = filePath.toFile();
//        if (file.exists()) {
//            try {
//                // Read from file and join all the lines into a string
//                return Files.readAllLines(filePath).stream().collect(Collectors.joining());
//            } catch (IOException e) {
//                return "Exception occurred while reading file" + e.getMessage();
//            }
//        }
//        return "File doesn't exist. Cannot download";
//    }
//
//    private static int countFiles() {
//        // Count the number of files in the storage folder
//        return new File("storage").listFiles().length;
//    }
//
//    private static String deleteFile(String fileName) {
//        File file = Paths.get("storage").resolve(fileName).toFile();
//        if (file.exists()) {
//            file.delete();
//            return "File deleted";
//        } else {
//            return "File " + fileName + " doesn't exist";
//        }
//    }
//}
//
