
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
    private static final String DATA_PATTERN =  "(^[\\w+? ]+?\\w+?),(\\d+?),(\\w+?$)";
    private StudentCollection studCollection;
    private HashMap<String, Subject> subjectMap;
    /**
     * Constructor for objects of class studentManagementSystem
     */
    public studentManagementSystem()
    {
        // initialise instance variables
    }
    
    public void runSystem()
    {
        int option = 0;
        studCollection = new StudentCollection();
        subjectMap = new HashMap<String, Subject>();
        for(String subject: Subject.getAllSubjects())
        {
            subjectMap.put(subject, new Subject());
        }
        
        initialSystem();
        while(option != OPTION_EXIT) {
            displayOptions();
            option = chooseOption();
            executeOption(option);
        }
    }
     
    private void initialSystem()
    {
        String line = "";
        clearTerminal();
        System.out.println("-------Welcome to Stuedent Management System------");
        FileIO fileIO = new FileIO();
        ArrayList<Student> studList = fileIO.readStudentFile(DATABASE_FILENAME,DATA_PATTERN);
        for(Student stud: studList)
        {
            studCollection.add(stud);
            Subject subject = subjectMap.get(stud.getSubject().toUpperCase());
            subject.add(stud);
        }
    }
    
    
    
    private void displayOptions()
    {
        System.out.println("---------------------------------");
        System.out.println("\nPlease select an Option below:");
        System.out.println("(1) Add a new student");
        System.out.println("(2) Delete a student");
        System.out.println("(3) Find Student By Name");
        System.out.println("(4) List Students By Subject");
        System.out.println("(5) List All Students");
        System.out.println("(6) Exit System");
        System.out.print("Enter Your option: ");
    }
    
    
    private int chooseOption()
    {
        UserInput in = new UserInput();
        int option;
        try {
            option = in.getInt();
            return option;
        } catch(Exception ex) {
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
                System.out.println("\nInvalid option. Please try again.");
                break;
        }
   }
   
   private boolean addStudent()
   {
       UserInput in = new UserInput();
       String studName, studNum, studSubject;
       
       System.out.println("\n--------Add a new Student-----------\n");
       System.out.print("Please input student's name: ");
       studName =  in.getLine();
       
       System.out.print("Please input student's phone number: ");
       studNum = in.getLine();
       
       System.out.print("Please input student's subject: ");
       studSubject = in.getLine();
       
       try {
           if(!Student.isArgumentValid(studName, studNum, studSubject)) {
               throw new Exception("\nError: Invalid student profile.");
            } else if(studCollection.findByName(studName) != null) {
               throw new Exception("\nError: Student " + studName+ " has already existed.");
            } else {
               Student newStudent = new Student(studName, studNum, studSubject);
               studCollection.add(newStudent);
               Subject subject = subjectMap.get(studSubject.toUpperCase());
               subject.add(newStudent);
               System.out.println("\nSuccess: A new student added.");
               return true;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("\nFailure: Student added failed.");
            return false;
        }
   }
   
   private boolean deleteStudent()
   {
       UserInput in = new UserInput();
       String studName;
       
       System.out.println("\n--------Delete A Student-----------\n");
       System.out.print("Pease input the student's name you want to delete: ");
       studName = in.getLine();
       
       try {
           Student student = studCollection.findByName(studName);
           if(student != null) {
               Subject subject = subjectMap.get(student.getSubject().toUpperCase());
               studCollection.delete(student);
               subject.delete(student);
               System.out.println("\nSuccess: Student is deleted.");
               return true;
            } else {
               throw new Exception("\nError: Student cannot found.");
            }
       } catch(Exception ex) {
           System.out.println(ex.getMessage());
           System.out.println("Failure: Student deletion failed");
           return false;
       }
   }
   
   private boolean findStudentByName()
   {
       UserInput in = new UserInput();
       String queryName;
       System.out.println("\n--------Find The Student by Name-------\n");
       System.out.print("Please input the name:");
       queryName = in.getLine();
       
       
       try {
           Student stud = studCollection.findByName(queryName);
           if(stud != null)
           {
               System.out.print("\nQuery result: ");
               stud.displayInfo();
           }else {
               throw new Exception("Failure: Ttudent with name " + queryName + " not found.");
           }
           return true;
       } catch(Exception ex) {
          System.out.println(ex.getMessage());
          return false;
       }
   }
   
   private boolean listStudentsBySubject()
   {
       String subjectStr = "";
       UserInput in = new UserInput();

       System.out.println("\n----------List Students by Subject-------------\n");
       System.out.print("Please input your query subject: ");
       subjectStr = in.getLine();
       try {
         if(!Subject.contains(subjectStr))
            throw new Exception("\nError:No subject" + subjectStr + " found.");   
         Subject subject = subjectMap.get(subjectStr.toUpperCase());
         System.out.println("\nQuery result:");
         for(Student student: subject.listAll())
         {
             student.displayInfo();
         }
         return true;
       } catch(Exception ex) {
           System.out.println(ex.getMessage());
           return false;
       }
   }
   
   private boolean listAllStudents()
   {
       try {
           System.out.println("\n----------List All Students-------------\n");
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
        FileIO fileIO = new FileIO();
        fileIO.writeToFile(DATABASE_FILENAME, studCollection.listAll());
        studCollection = null;
        clearTerminal();
        System.out.println("Exit System");
    }
}
