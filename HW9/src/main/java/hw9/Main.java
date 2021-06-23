package hw9;

import hw9.controller.*;
import hw9.model.Options;
import hw9.model.ParseException;

public class Main{
    public static void main(String[] args){
        try {
            CommandLineParser parser = new CommandLineParser(args);
            Options input = parser.getOptions();
            //System.out.println(input+"\n");
            Facade testController = new Facade(input);

        }catch (IllegalArgumentException | ParseException | ReadFileException | java.text.ParseException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
