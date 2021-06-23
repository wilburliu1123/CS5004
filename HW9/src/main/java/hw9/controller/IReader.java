package hw9.controller;

import java.util.List;


public interface IReader {

    /**
     * Read the input csv file and convert it to its list representation.
     * @param path - file path, represented as string.
     * @return line - List representation of the input file's each line
     * @throws ReadFileException - thrown when a given path is not valid.
     */
    List<String> readFile(String path) throws ReadFileException;

    /**
     * Gets the array list representation of the input file
     * @return array list representation of the input file
     */
    List<List<String>> getInputFile();
}
