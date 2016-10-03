
/**
 * Write a description of class FileIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileIO
{
    /**
     * Constructor for objects of class FileIO
     */
    public FileIO()
    {
        // initialise instance variables
    }
    
    public ArrayList<Student> readStudentFile(String filename, String dataPattern)
    {
        String line = "";
        ArrayList<Student> studList = new ArrayList<Student>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                studList.add(readStudentData(line, dataPattern));
            }
            bufferedReader.close();
            fileReader.close();
            return studList;
        } catch(IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private Student readStudentData(String line, String dataPattern)
    {
        Pattern reg = Pattern.compile(dataPattern);
        Matcher m = reg.matcher(line);
        if(m.find()){
            String studName = m.group(1);
            String studPhone = m.group(2);
            String studSubject = m.group(3);
            Student student = new Student(studName, studPhone, studSubject);
            return student;
            //student.displayInfo();
        }else {
            System.out.println("NO MATCH");
            return null;
        }
    }
    
    public void writeToFile(String fileName, ArrayList<Student> studList)
    {
        FileOutputStream fop =null;
        File file;
        String dataLines = writeStudentData(studList);
        try {
            file = new File(fileName);
            fop = new FileOutputStream(file);
            
            byte[] contentInBytes = dataLines.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Database updated.");
        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(fop != null) {
                    fop.close();
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private String writeStudentData(ArrayList<Student> studList)
    {
        String lines = "";
        for(Student student: studList)
        {
            lines += student.toString() + "\n";
        }
        return lines;
    }
}
