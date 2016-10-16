import java.util.ArrayList;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Provide a range of file-handling operations on an StudentManagementSystem.
 * 
 * @author Dong Cai
 * @version 2016.10.4
 */
public class FileHandler
{
    /**
     * Constructor for objects of class FileHandler
     */
    public FileHandler()
    {
        // initialise instance variables
    }

    /**
     * Read data from file
     * @param file name
     * @return student list
     */
    public ArrayList<String> readFromFile(String filename) throws IOException
    {
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        StudentCollection studList = new StudentCollection();

        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null)
        {
            lines.add(line);
        }
        bufferedReader.close();
        fileReader.close();
        return lines;
    }    

    /**
     * Read student data from line
     * @param line
     * @return student profile
     */
    public Student readStudentData(String line) throws IOException
    {
        String[] attrs = line.split(",");
        if(attrs.length == 3){
            String studName = attrs[0];
            String studPhone = attrs[1];
            String studSubject = attrs[2];
            try{
                Student student = new Student(studName, studPhone, studSubject);
                return student;
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
            //student.displayInfo();
        }else {
            System.out.println("NO MATCH");
            return null;
        }
    }

    /**
     * Write student data to file 
     * @param target file name, student list
     */ 
    public void writeToFile(String fileName, String lines) throws IOException
    {
        FileOutputStream fop =null;
        File file;
        // String dataLines = writeStudentData(studList.getAll());
        file = new File(fileName);
        fop = new FileOutputStream(file);

        byte[] contentInBytes = lines.getBytes();
        fop.write(contentInBytes);
        fop.flush();
        fop.close();
        System.out.println("Database updated.");           
    }

    /**
     * Change student data into text
     * @param student list
     * @return text of all student data
     */
    public String writeStudentData(ArrayList<Student> studList) throws IOException
    {
        String lines = "";
        for(Student student: studList)
        {
            lines += student.toString() + "\n";
        }
        return lines;
    }
}
