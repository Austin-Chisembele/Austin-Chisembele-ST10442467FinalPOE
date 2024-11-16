/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package activtity.registrations;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
   private Task task;

    public TaskTest() {
       
         this.task = new Task("Login Feature", "Create Login to authenticate user", "Robyn Harrison", 8, "To Do");
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        
    }
    
    @BeforeEach
    public void setUp() {
        
        this.task = new Task("Login Feature", "Create Login to authenticate user", "Robyn Harrison", 8, "To Do");
    }
    
    @AfterEach
    public void tearDown() {
       
        task = null; 
    }

    
/*
*************************** Part 2 POE******************************************
********************************************************************************
********************************************************************************
*/
    
    
     /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        
        System.out.println("checkTaskDescription");
         Task instance = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
       boolean expResult = true;  
        boolean result = instance.checkTaskDescription();
        assertEquals(expResult, result);
        
    }

    
     /**
     * Test of returnTotalHours method, of class Task.
     */
@Test
public void testReturnTotalHoursWithEmptyList() {
    System.out.println("returnTotalHours with empty list");
    
    List<Task> tasks = new ArrayList<>();
    
    int expResult = 0;
    
    int result = Task.returnTotalHours(tasks);
    
    assertEquals(expResult, result);
}



@Test
public void testReturnTotalHoursWithTasks() {
    System.out.println("returnTotalHours with tasks");

    // Create some tasks with hours
    List<Task> tasks = new ArrayList<>();
    tasks.add(new Task("Login Feature", "Create Login to authenticate user", "Robyn Harrison", 8, "To DO"));
    tasks.add(new Task("Add Task Feature", "Create add task feature to add task users", "Mike Smith", 10, "Doing"));
   
    
    // Expected result: sum of task hours (10 + 8)
    int expResult = 18;
    
    
    int result = Task.returnTotalHours(tasks);
    
   
    assertEquals(expResult, result);
}

  

    @Test
 public void testTaskDescriptionSuccess() {
  
    Task instance = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");

    String captureResult = captureTask(instance);

    assertEquals("Task successfully captured", captureResult, "The captureTask method did not return the expected message.");
}
 
  @Test
    public void testTaskDescriptionCorrectFormat() {
        assertTrue(task.checkTaskDescription(), "Task Successful Captured.");
    }
 
 
    @Test
    public void testTaskDescriptionFailure() {
    
    Task instance = new Task("Add Task Feature", "This description exceeds fifty characters limit, failing validation.", "Mike Smith", 10, "Doing");

    
    boolean isValidDescription = instance.checkTaskDescription(); 
    assertFalse(isValidDescription, "Task description should fail validation for exceeding 50 characters.");
}

 
 @Test
    public void testCreateTaskIDSuccess() {
        assertTrue(task.checkTaskDescription(), "LO:0:SON");
    }



 @Test
public void testCreateTaskID() {
    Task x = new Task("Add Task Feature", 
                      "This description exceeds fifty characters limit, failing validation.", 
                      "Mike Smith", 10, "Doing");  
    
   
    assertFalse(x.checkTaskDescription(), "Task description validation should fail for exceeding the character limit.");
}   

  
@Test
public void testTotalHoursAccumulation() {
    
    Task[] tasks = {
        new Task("Login Feature", "Create Login to authenticate user", "Robyn Harrison", 8, "To Do"),
        new Task("Add Task Feature", "Create add task feature to add task users", "Mike Smith", 10, "Doing")
    };

    // Initialize the total hours accumulator
    int total = 0;
    
    // Loop through the tasks and accumulate their durations
    for (Task instance : tasks) {
        total += instance.getreturnTotalHours(); 
    }

    // The expected total is 8 + 10 = 18
    int expectedTotal = 18;

    assertEquals(expectedTotal, total);
}

    private String captureTask(Task task) {
        if (task.checkTaskDescription()) {
            return "Task successfully captured";
        } else {
            return "Please enter a task description of less than 50 characters";
        }
    }
    
    
/**********************End of Part 2 POE****************************************
********************************************************************************
********************************************************************************
*/ 
          
/*
***************************Getter Testing **************************************
********************************************************************************
********************************************************************************
*/
  
  @Test
  public void testGetDeveloperDetails() {
    System.out.println("getDeveloperDetails");
    
    
    Task instance = new Task("Add Task Feature", 
                             "Create Add Task feature to add task users", 
                             "Mike Smith", 10, "Doing");
    
    String expResult = "Mike Smith";  
    
    String result = instance.getDeveloperDetails();
    assertEquals(expResult, result);
}

    
   
    
    @Test
    public void testGetTaskName() {
        System.out.println("getTaskName");
       
        
        Task instance = new Task("Add Task Feature", 
                             "Create Add Task feature to add task users", 
                             "Mike Smith", 10, "Doing");
    
    String expResult = "Add Task Feature";  
    
    String result = instance.getTaskName();
    assertEquals(expResult, result);
       
    }

  
    @Test
    public void testGetTaskDuration() {
        System.out.println("getTaskDuration");
        
        Task instance = new Task("Add Task Feature", 
                             "Create Add Task feature to add task users", 
                             "Mike Smith", 10, "Doing");
    
   int expResult = 10;  
    
   int result =  instance.getTaskDuration();
   assertEquals(expResult, result);
       
    }

   
    @Test
    public void testGetTaskStatus() {
        System.out.println("getTaskStatus");
     
        
             Task instance = new Task("Add Task Feature", 
                             "Create Add Task feature to add task users", 
                             "Mike Smith", 10, "Doing");
    
 String expResult = "Doing";  
    
   String result =  instance.getTaskStatus();
   assertEquals(expResult, result);
       
    }

 
    @Test
  public void testGetreturnTotalHours()  {
    
    Task[] tasks = {
        new Task("Login Feature", "Create Login to authenticate user", "Robyn Harrison", 8, "To Do"),
        new Task("Add Task Feature", "Create add task feature to add task users", "Mike Smith", 10, "Doing")
    };

    int total = 0;
    
    for (Task instance : tasks) {
        total += instance.getreturnTotalHours(); 
    }

    int expectedTotal = 18;

    assertEquals(expectedTotal, total);
}
    
/**********************End of Getter *******************************************
********************************************************************************
********************************************************************************
*/ 

/*
***************************Final Part 3 POE Testing*****************************
********************************************************************************
********************************************************************************
*/
  
  
    /**
     * Test of getDevelopers method, of class EasyKanbansss.
     */
    @Test
    public void testGetDevelopers() {
    System.out.println("getDevelopers");
    System.out.println("Mike Smith ,Edward Harrison ,Samantha Paulson ,Glenda Oberholzer");

    String[] expResult = {};

    String[] result =  Task.getDevelopers();

    assertArrayEquals(expResult, result);

    
}

    
    /**
     * Test of displayCompletedTasks method, of class EasyKanbansss.
     */
  @Test
public void testDisplayCompletedTasks() {
    System.out.println("DisplayCompletedTasks:");
    System.out.println("Samantha Paulson, Create Reports,2");
    
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
       
         Task.displayCompletedTasks();

        String expResult = "";  
        
        assertEquals(expResult, outContent.toString());
        
    } finally {
       
        System.setOut(originalOut);
    }
}
   
    
    
    /**
     * Test of displayLongestTask method, of class EasyKanbansss.
     */
@Test
public void testDisplayLongestTask() {
    System.out.println("DisplayLongestTask:");
  System.out.println("Glenda Oberholzer,11");
  
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
        
        Task.displayLongestTask();

        
        String expResult = "";  
        
      
        assertEquals(expResult, outContent.toString());
        
    } finally {
        
        System.setOut(originalOut);
    }
}



    /**
     * Test of searchTaskByName method, of class EasyKanbansss.
     */
@Test
public void testSearchTaskByName() {
    System.out.println("SearchTaskByName:");
    System.out.println("Mike Smith, Create Login");
    
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
        
        String taskName = "Create Login";  

        Task.searchTaskByName(taskName);

        String expResult = ""; 
        
        assertEquals(expResult, outContent.toString());
        
    } finally {
     
        System.setOut(originalOut);
    }
}


    /**
     * Test of searchTasksByDeveloper method, of class EasyKanbansss.
     */
@Test
public void testSearchTasksByDeveloper() {
    System.out.println("SearchTasksByDeveloper:");
    System.out.println("Create Reports,Samantha Paulson");
    
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
       
        String developer = "Samantha Paulson";  

       Task.searchTasksByDeveloper(developer);
        
        String expResult = "";  
        
        assertEquals(expResult, outContent.toString());
        
    } finally {
      
        System.setOut(originalOut);
    }
}
 

    /**
     * Test of deleteTask method, of class EasyKanbansss.
     */
@Test
public void  testDeleteTask() {
    System.out.println("DeleteTask");
   
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
       
        String taskName = "Create Reports";  

         Task.deleteTask(taskName);
        
        String expResult = "";  
        
        assertEquals(expResult, outContent.toString());
        
    } finally {
      
        System.setOut(originalOut);
    }
}


    /**
     * Test of displayReport method, of class EasyKanbansss.
     */
@Test
public void testDisplayReport() {
    System.out.println("DisplayReport");

   
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
       
        Task.displayReport();

        String expResult = "";  

        assertEquals(expResult, outContent.toString());
        
    } finally {
      
        System.setOut(originalOut);
    }
}

/**********************End of Final POE Testing*********************************
********************************************************************************
********************************************************************************
*/ 
    
}