package hw9.controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Read from user input CSV file and read each line as an Arraylist. Store each list of lines in
 * an ArrayList List<List<String>> inputFile.
 */
public class Reader implements IReader{
    private List<List<String>> inputFile;

    /**
     * Constructor of a Reader Class.
     * @param path - the input path, represented as a String.
     * @throws ReadFileException - thrown when a given path is not valid.
     */
    public Reader(String path) throws ReadFileException {
        this.inputFile = new ArrayList<>();
        this.populateList(path);
    }

    /**
     * Populate a Todo Lit from a line of the input CSV file
     * @param path - the input path, represented as a String.
     * @throws ReadFileException - thrown when a given path is not valid.
     */
    private void populateList(String path) throws ReadFileException {
        List<String> file = this.readFile(path);
        this.processInput(file);
    }

    @Override
    /**
     * Read the input csv file and convert it to its list representation.
     * @param path - file path, represented as string.
     * @return line - List representation of the input file's each line
     * @throws ReadFileException - thrown when a given path is not valid.
     */
    public List<String> readFile(String path) throws ReadFileException{
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = reader.readLine()) != null)
                lines.add(line);
        } catch (FileNotFoundException e) {
            throw new ReadFileException("CSV file not found");
        } catch (IOException e) {
            throw new ReadFileException("IO exception");
        }
        return lines;
    }

    /**
     * Process input file to correct format.
     * @param lines - Liners read from input csvFile w/o header
     */
    private void processInput(List<String> lines) {
        String pattern = "\"(.*?)\"";
        Pattern r = Pattern.compile(pattern);
        for (int i = 1; i < lines.size(); i++) {
            List<String> temp = new ArrayList<>();
            Matcher matcher = r.matcher(lines.get(i));
            while (matcher.find()) {
                String str = matcher.group().replaceAll("\"", "");
                temp.add(str);
            }
            this.inputFile.add(temp);
        }
    }

    /**
     * Gets the array list representation of the input file
     * @return array list representation of the input file
     */
    @Override
    public List<List<String>> getInputFile() {
        return this.inputFile;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "inputFile=" + inputFile +
                '}';
    }
}
