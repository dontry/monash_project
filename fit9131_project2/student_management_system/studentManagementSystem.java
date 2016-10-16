import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

/**
 * Provide a StudentManagementSystem class.
 * It is the user interface.
 * 
 * @author Dong Cai 
 * @version 2016.10.4
 */
public class StudentManagementSystem
{
    private static final int OPTION_EXIT = 6;
    private static final String DATABASE_FILENAME = "student.list";
    private static final String SUBJECTOPT_FILENAME = "subjectopt.list";
    //private static final String DATA_PATTERN =  "(^[\\w+? ]+?\\w+?),(\\d+?),(\\w+?$)";
    private StudentCollection studCollection;
    /**
     * Constructor for objects of class studentManagementSystem.
     * The initialization of class fields are put into the runSystem other than constructor.
     * It is assumed that the fields are initialized everytime the System is boot
     */
    public StudentManagementSystem()
    {
    }

    /**
     * The main body of system.
     */
    public void runSystem()
    {
        int option = 0;
        initialSystem();
        while(option != OPTION_EXIT) {
            displayMenu();
            option = chooseOption();
            executeOption(option);
        }
    }

    /**
     * Perform initialization for the studentCollection.
     * Reading student data from student.list.
     */
    private void initialSystem()
    {
        clearTerminal();
        initSubjectOption();
        initStudentCollection();
        System.out.println("-----------Student Management System-------------");
    }

    /**
     * Perform initialization for subject options
     * Reading subject option from subjectopt.list
     */
    private void initSubjectOption()
    {
        FileHandler fileHdlr = new FileHandler();
        try {
            ArrayList<String> subjectOpts = fileHdlr.readFromFile(SUBJECTOPT_FILENAME);
            SubjectCollection.initSubjectOption(subjectOpts);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Perform initialization for student list
     * Reading student profile from student.list
     */
    private void initStudentCollection()
    {
        FileHandler fileHdlr = new FileHandler();
        studCollection = new StudentCollection();
        try {
            ArrayList<String> lines = fileHdlr.readFromFile(DATABASE_FILENAME);
            for(String line: lines)
            {
                Student stud = fileHdlr.readStudentData(line);
                studCollection.add(stud);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Display system menu.
     */
    private void displayMenu()
    {
        System.out.println("----------------------Menu-----------------------");
        System.out.println("\nPlease select an Option below:");
        System.out.println("(1) Add a new student");
        System.out.println("(2) Delete a student");
        System.out.println("(3) Find Student By Name");
        System.out.println("(4) List Students By Subject");
        System.out.println("(5) List All Students");
        System.out.println("(6) Exit System");
        System.out.print("Enter Your option: ");
    }

    /**
     * Get the user's option
     * @return user's option
     */
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

    /**
     * Execute the command according to user's option.
     * @param The user option.
     */
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
        System.out.println("---------------------------------------------------");
    }

    /**
     * Add new student profile with user input.
     * @return true if add student successful, false otherwise.
     */
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
            if(studCollection.findByName(studName) != null) {
                throw new Exception("\nError: Student " + studName+ " has already existed.");
            } else {
                Student newStudent = new Student(studName, studNum, studSubject);
                studCollection.add(newStudent);
                System.out.println("\nSuccess: A new student added.");
                return true;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("\nFailure: Student added failed.");
            return false;
        }
    }

    /**
     * Delete student by user's input name.
     * @return true if delete student successful, false otherwise. 
     */
    private boolean deleteStudent()
    {
        UserInput in = new UserInput();
        String studName;

        System.out.println("\n--------Delete A Student-----------\n");
        System.out.print("Pease input the student's name you want to delete: ");
        studName = in.getLine();

        try {
            Student student = studCollection.findByName(studName);
            if(student == null) 
                throw new Exception("\nError: Student cannot found.");
            studCollection.delete(student);
            System.out.println("\nSuccess: Student is deleted.");
            return true;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Failure: Student deletion failed");
            return false;
        }
    }

    /**
     * Find student by user's input name.
     * @return true if find out student, false otherwise.
     */
    private boolean findStudentByName()
    {
        UserInput in = new UserInput();
        String queryName;
        System.out.println("\n--------Find The Student by Name-------\n");
        System.out.print("Please input the name:");
        queryName = in.getLine();

        try {
            Student stud = studCollection.findByName(queryName);
            if(stud == null)
                throw new Exception("Failure: Student with name " + queryName + " not found.");
            System.out.print("\nQuery result: ");
            stud.displayInfo();
            return true;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * List student by user's input subject.
     * @return true if list students successful, false otherwise.
     */
    private boolean listStudentsBySubject()
    {
        String subjectStr = "";
        UserInput in = new UserInput();

        System.out.println("\n----------List Students by Subject-------------\n");
        System.out.print("Please input your query subject: ");
        subjectStr = in.getLine();
        String[] subjectArray = subjectStr.trim().split(" ");
        try {
            for(String subj: subjectArray)
            {
                if(!SubjectCollection.exist(subj))
                    throw new Exception("\nError:No subject called " + subjectStr + " found.");          
            }
            ArrayList<Student> studList = studCollection.searchBySubjects(subjectArray);

            System.out.println("\nQuery result:");
            if(studList.size() == 0)
            {
                System.out.println("No student found.");
            } else {
                for(Student stud: studList)
                {
                    stud.displayInfo();
                }
            }

            return true;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * List all student
     * @return true if list all students successful, false otherwise.
     */
    private boolean listAllStudents()
    {
        try {
            System.out.println("\n----------List All Students-------------\n");
            for(Student student: studCollection.getAll())
            {
                student.displayInfo();
            }
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Clear terminal screen.
     */
    private void clearTerminal()
    {
        System.out.print('\u000C');
    }

    /**
     * Exit system.
     * Write the student data to file.
     * Set studentColletion to null.
     * Clear terminal.
     */
    private void exitSystem()
    {
        FileHandler fileHdlr = new FileHandler();
        try {
            String data = fileHdlr.writeStudentData(studCollection.getAll());
            fileHdlr.writeToFile(DATABASE_FILENAME, data);
        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            studCollection = null;
            clearTerminal();
            System.out.println("Exit System");
        }
    }
}
