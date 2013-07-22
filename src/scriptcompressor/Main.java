package scriptcompressor;

/**
 *
 * @author Carlos Sepulveda
 */
public class Main {

    public static void main(String [] args) {
        ScriptsCompressor compressor = new ScriptsCompressor();
        compressor.processFolder("/your/js/input/folder/", "/your/output/folder/");
        compressor.processFolder("/your/css/input/folder/", "your/output/folder2/");
    }
}
