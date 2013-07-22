package scriptcompressor;

import java.io.File;

/**
 *
 * @author Carlos Sepulveda
 */
public class ScriptsCompressor {

    public void processFolder(String folderIn, String folderOut) {
        createFolder(folderOut);
        File folder = new File(folderIn);
        processFolder(folder, folderOut);
    }

    private void processFolder(File folder, String output) {
        createFolder(output);
        for (File f : folder.listFiles()) {
            if(f.isDirectory()) {
                processFolder(f, output +f.getName() + "/");
            } else {
                processFile(f, output);
            }
        }
    }

    private void processFile(File file, String output) {
        try {
            String inputFile = file.getAbsolutePath();
            String outputFile = output + file.getName();
            String process = "java -jar lib/yuicompressor.jar " + inputFile + " -o "+ outputFile + " --charset utf-8";
            Runtime.getRuntime().exec (process); 
        } catch (Exception e) {
            System.out.println("Error trying to process file " + e.getMessage());
        }
    }

    private void createFolder(String path) {
        File newFolder = new File(path);
        newFolder.mkdir();
    }
}
