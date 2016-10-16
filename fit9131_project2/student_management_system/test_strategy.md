 # Test Strategy
 This is a documentation which lists how we test class or program.
 ## Test Plan
 This is a summary of all the tests which will be eventually performed for the program.
 
We will use class, **Student**, to demonstrate our test strategy.

The **Student** class has three attributes: *Name*, *Phone Number*, *Subjects*
+ the *Name* is a Capitalised string
+ the *Phone Number* is a string of 9 numeric characters. The first character is '9'
+ the *Subjects* is an instance of **SubjectCollection**, which stores a list of **Subject** objects.

There are two constructors, plus the usual accessors and mutators.

## Class diagram for Student class
|Student                           |
|:---------------------------------|
|name: String                      |
|phoneNum: String                  |
|subjects: SubjectCollection       |
|*Subject()*                       |
|*Subject(String,String,String)*   |
|*getName()*: String               |
|*getPhoneNum()*: String           |
|*getSubjects()*: String           |
|*setName(String)*: boolean        |
|*setPhoneNum(String)*: boolean    |
|*setSbuject(String)*: boolean     |
|*addSubject(String)*: boolean     |
|*hasSubject(String)*: boolean     |
|*displayInfo()*                   |
|*toString()*: String              |
|*capitalise(String)*: String      |
|*isNameValidReg(String)*: boolean |
|*isPhoneValidReg(String)*: boolean|
|*isSubjectValid(String)*: boolean |

## Student class constructor tests
### Test1
Create a **Student** object with the default constructor
##### Test Data:
+ No inut
##### Expected Results:
+ name: ""
+ phoneNum: ""
+ subjects: SubjectCollection()
##### Actual Results:
![alt text](file://documents/monash_projects)
### Test2
Create a **Student** object with the non-default constructor
##### Test Data
+ name: "William Smith"
+ phoneNum: "912345678"
+ subject: "Maths English"
##### Expected Results:
+ name: "William Smith"
+ phoneNum: "912345678"
+ subject: SubjectCollection(Maths, English)
##### Actual Results:

### Test3
Create a **Student** object with invalid attributes
##### Test Data
+ name: "Eric Connor"
+ phoneNum: "888888888"
+ subject: "Computing"
##### Expected Results:
##### Actual Results:
----
## Student method tests
### Constructor
##### Student("William Smith", "987654321", "English Maths")

### getName(): String
##### Expected Data
 + name: "William Smith"
##### Actual Data


### getPhoneNum(): String 
##### Expected Data
+ phone: "987654321"
##### Actual Data


### getSubjects(): String
##### Expected Data
+ subjects: "English Maths"
##### Actual Data

---
### SetName(String): boolean  -positive
##### Test Data
+ name: "William Smith"
##### Expected Data
+ boolean: true
##### Actual Data

### SetName(String): boolean -negative
##### Test Data
+ name: "William123 Smith"
##### Expected Data
+ boolean: false
##### Actual Data

### SetPhoneNum(String): boolean -positive
##### Test Data
+ phone: "987654321"
##### Expected Data
+ boolean: true
##### Actual Data

### SetPhoneNum(String): boolean -negative
##### Test Data
+ phone: "77700888"
##### Expected Data
+ boolean: false
##### Actual Data

### SetSubjects(String): boolean -positive
##### Test Data
+ subjects: "Maths Computing"
##### Expected Data
+ boolean: true
##### Actual Data

### SetSubjects(String): boolean -negative
##### Test Data
+ subjects: "Art Psychology"
##### Expected Data
+ boolean: false
##### Actual Data






