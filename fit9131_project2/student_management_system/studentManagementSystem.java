
/**
 * Write a description of class studentManagementSystem here.
 * 
 * @author (Dong Cai) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
//import java.nio.file;

public class studentManagementSystem
{
    private static final int OPTION_EXIT = 6;
    private static final String DATABASE_FILENAME = "student.list";
    private static final String DATA_PATTERN =  "(^\\w+? \\w+?),(\\d+?),(\\w+?$)";
    private StudentCollection studCollection;
    
    /**
     * Constructor for objects of class studentManagementSystem
     */
    public studentManagementSystem()
    {
        // initialise instance variables
        studCollection = new StudentCollection();
    }
    
    public boolean bootSystem()
    {
        int option = 0;
        initialSystem();
        while(option != OPTION_EXIT) {
            displayOptions();
            option = chooseOption();
            executeOption(option);
        }
        return false;
    }
     
    private void initialSystem()
    {
        String line = "";
        clearTerminal();
        try {
            FileReader fileReader = new FileReader(DATABASE_FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                readData(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private void readData(String line)
    {
        Pattern reg = Pattern.compile(DATA_PATTERN);
        Matcher m = reg.matcher(line);
        if(m.find()){
            Student student = new Student(m.group(1), m.group(2), m.group(3));
            studCollection.add(student);
        }else {
            System.out.println("NO MATCH");
        }
    }
    
    private void writeToFile(String lines)
    {
        FileOutputStream fop =null;
        File file;
        try {
            file = new File(DATABASE_FILENAME);
            fop = new FileOutputStream(file);
            
            byte[] contentInBytes = lines.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Database has updated.");
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
    
    private String writeData()
    {
        String lines = "";
        for(Student student: studCollection.listAll())
        {
            lines += student.toString() + "\n";
        }
        return lines;
    }
    
    private void displayOptions()
    {
        System.out.println("\nPlease select an Option below:");
        System.out.println("(1) Add a new student");
        System.out.println("(2) Delete a student");
        System.out.println("(3) Find Student By Name");
        System.out.println("(4) List Students By Subject");
        System.out.println("(5) List All Students");
        System.out.println("(6) Exit System");
        System.out.print("Your option: ");
    }
    
    
    private int chooseOption()
    {
        UserInput in = new UserInput();
        int option;
        try {
            option = in.getInt();
            return option;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
   
    private void executeOption(int option)
    {
        switch(option)
        {
            case 1:
                addStudent();
                break;
            case 2: 
                deleteStudent();
                break;
            case 3:
                findStudentByName();
                break;
            case 4:
                listStudentsBySubject();
                break;
            case 5:
                listAllStudents();
                break;
            case 6:
                exitSystem();
                break;
            default:
                System.out.print("Invalid option. Please try again.");
        }
   }
   
   private boolean addStudent()
   {
       UserInput in = new UserInput();
       String studName, studNum, studSubject;
       
       System.out.println("\n------Add a new Student-----------");
       System.out.print("Please input student's name: ");
       studName =  in.getLine();
       
       System.out.print("Please input student's phone number: ");
       studNum = in.getLine();
       
       System.out.print("Please input student's subject: ");
       studSubject = in.getLine();
       
       try {
           if(Student.isArgumentValid(studName, studNum, studSubject)) {
               Student newStudent = new Student(studName, studNum, studSubject);
               studCollection.add(newStudent);
               System.out.println("Success: New student added");
               newStudent.displayInfo();
               return true;
            } else {
                throw new Exception();
            }
        } catch(Exception ex) {
            System.out.println("Failure: Invalid student info");
            return false;
        }
   }
   
   private boolean deleteStudent()
   {
       UserInput in = new UserInput();
       String studName;
       
       System.out.print("Pease input the student's name you want to delete: ");
       studName = in.getLine();
       
       try {
           studCollection.delete(studName);
           System.out.println("Success: Student deleted");
           return true;
       } catch(Exception ex) {
           System.out.println("Failure: Student deletion failed");
           return false;
       }
   }
   
   private boolean findStudentByName()
   {
       UserInput in = new UserInput();
       String queryName;
       System.out.println("\n------------Find the student by name:------------");
       System.out.print("Please input the name:");
       queryName = in.getLine();
       
       
       try {
           System.out.println("\n----------Find student by name-------------");
           Student stud = studCollection.findByName(queryName);
           if(stud != null)
           {
               System.out.print("Find the student:");
               stud.displayInfo();
           }else {
               System.out.println("Cannot find the student with name " + queryName);
           }
           return true;
       } catch(Exception ex) {
          return false;
       }
   }
   
   private boolean listStudentsBySubject()
   {
       try {
         System.out.println("\n-------------List Students by Subject-------------");
         HashMap<String, ArrayList<Student>> list = studCollection.listStudsBySubject();
         for(String subject: Subject.getSubjectOptions())
         {
             ArrayList<Student> studList = list.get(subject);
             System.out.println(subject + ":");
             for(Student student: studList)
             {
                 student.displayInfo();
             }
         }
         return true;
       } catch(Exception ex) {
           return false;
       }
   }
   
   private boolean listAllStudents()
   {
       try {
           System.out.println("\n----------List All Students-------------");
           for(Student student: studCollection.listAll())
           {
               student.displayInfo();
            }
           return true;
       } catch(Exception ex) {
           return false;
       }
   }
   
    private void clearTerminal()
    {
        System.out.print('\u000C');
    }
    
    private void exitSystem()
    {
        String data = writeData();
        writeToFile(data);
        studCollection = null;
        clearTerminal();
    }
}
