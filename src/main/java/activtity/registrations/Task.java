/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activtity.registrations;


/**
 *
 * @author RC_Student_lab
 */

/*
***************************External POE File************************************
********************************************************************************
********************************************************************************
*/
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


class Task {
       private static final ArrayList<Task> taskList = new ArrayList<>();//part 3 poe codes
/*
*************************** Part 2 POE******************************************
********************************************************************************
********************************************************************************
*/
    
    
    private static int taskCounter = 0;
    private final String taskName;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskStatus;

    
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        taskCounter++;
        this.taskStatus = taskStatus;
    }
   
     
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String initials = taskName.substring(0, 2).toUpperCase();
        String devLastThree = developerDetails.split(" ")[1].substring(0, 3).toUpperCase();
        return initials + ":" + (taskCounter - 1) + ":" + devLastThree;
    }

    public String printTaskDetails() {
           
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + (taskCounter - 1) + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + createTaskID() + "\n" +
               "Duration: " + taskDuration + " hrs";
    }

    public static int returnTotalHours(List<Task> tasks) {
        int total = 0;
        for (Task task : tasks) {
            total += task.taskDuration;
        }
        return total;
    }
   
    
/**********************End of Part 2 POE****************************************
********************************************************************************
********************************************************************************
*/

    
/*
***************************Adding task Part 2***********************************
********************************************************************************
********************************************************************************
*/

     static void attachTasks() {
         
        List<Task> tasks = new ArrayList<>();
         
            int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));
            
            for (int i = 0; i < numTasks; i++) {
                String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 chars):");
                
                if (!new Task(taskName, taskDescription, "", 0, "").checkTaskDescription()) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                    i--; // decrement i to retry
                    continue;
                }
                
                String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First Last):");
                int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (hrs):"));
                String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:",
                        "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Doing", "Done"}, "To Do");
                
                //Call the class called Task from external class
                Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
                tasks.add(task);
                 JOptionPane.showMessageDialog(null, "Tasks added successfully!");
                JOptionPane.showMessageDialog(null, task.printTaskDetails());
            }
            int totalHours = Task.returnTotalHours(tasks);
            JOptionPane.showMessageDialog(null, "Total Hours: " + totalHours);
            JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban!");
    }
/**********************End of Adding task Part 2********************************
********************************************************************************
********************************************************************************
*/   
         
/*
***************************Getter Methods***************************************
********************************************************************************
********************************************************************************
*/
    
      public String getprintTaskDetails() {
           
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + (taskCounter - 1) + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + createTaskID() + "\n" +
               "Duration: " + taskDuration + " hrs";
    }
    
    public String getDeveloperDetails() {
        return developerDetails;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }
    
  
      public int getreturnTotalHours() {
        return taskDuration;
    } 

/**********************End of Getter********************************************
********************************************************************************
********************************************************************************
*/ 

/*
***************************Final Part 3 POE*************************************
********************************************************************************
********************************************************************************
*/

    static void populateTasks() {
   
       StringBuilder reportBuilder = new StringBuilder();
      
        taskList.add(new Task("Create Login", "Create Login to authenticate users", "Mike Smith", 5, "To Do"));
        taskList.add(new Task("Create Add Features", "Create additional features", "Edward Harrison", 8, "Doing"));
        taskList.add(new Task("Create Reports", "Generate reports", "Samantha Paulson", 2, "Done"));
        taskList.add(new Task("Add Arrays", "Implement array features", "Glenda Oberholzer", 11, "To Do"));
   
         JOptionPane.showMessageDialog(null,"Display Populate Tasks");
        // Iterating over the task list and collecting details
        for (Task task : taskList ) {
            reportBuilder.append(task.getprintTaskDetails()).append("\n\n"); // Append task details with spacing
          
        }
        
        // Displaying the task details using JOptionPane
        JOptionPane.showMessageDialog(null, reportBuilder.toString(), "Details of Tasks ", JOptionPane.INFORMATION_MESSAGE);
    }

    
    public static String[] getDevelopers() {
        return taskList.stream().map(Task::getDeveloperDetails).distinct().toArray(String[]::new);
        
    }

    public static void displayCompletedTasks() {
          
               JOptionPane.showMessageDialog(null,"Display Completed Tasks");
        for (Task task : taskList) {
            if (task.getTaskStatus().equals("Done")) {
                
                   JOptionPane.showMessageDialog(null,"Display Completed Tasks: " + task.getDeveloperDetails() + " , " + task.getTaskName() + " , " + task.getTaskDuration());
            }
        }
       
    }

    public static void displayLongestTask() {
         
             JOptionPane.showMessageDialog(null,"Display Longest Task");
        Task longestTask = taskList.stream().max((t1, t2) -> Integer.compare(t1.getTaskDuration(), t2.getTaskDuration())).orElse(null);
        if (longestTask != null) {
            
            JOptionPane.showMessageDialog(null,"Display Longest Task: " + longestTask.getDeveloperDetails() + " , " + longestTask.getTaskDuration());
        }
           
    }

    public static void searchTaskByName(String taskName) {

          JOptionPane.showMessageDialog(null,"Search for Task Name");
        for (Task task : taskList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
             
                 JOptionPane.showMessageDialog(null,"Display Search Task By Name: " + task.getTaskName()  + " , " + task.getDeveloperDetails() + " , " + task.getTaskStatus()+ " , " + task.getTaskDuration());
                  JOptionPane.showMessageDialog(null,"Task  found.");
               return;
               
            }else{
                JOptionPane.showMessageDialog(null,"Task not found.");
             
              return;
            }  
        }
    
    }
    
    
    public static void searchTasksByDeveloper(String developer) {
         
            JOptionPane.showMessageDialog(null,"Search for Task Developer");
        for (Task task : taskList) {
            if (task.getDeveloperDetails().equalsIgnoreCase(developer)) {
                
                 JOptionPane.showMessageDialog(null,"Display Search Task By Developer: " + task.getTaskName() + " , " + task.getDeveloperDetails() + " , " + task.getTaskStatus()+ " , " + task.getTaskDuration());
                 JOptionPane.showMessageDialog(null,"Developer Task found.");
                
             
            }
             
        }
       
              
    }

    public static void deleteTask(String taskName) {
      
           JOptionPane.showMessageDialog(null,"Delete Task Name");
        taskList.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
      
          JOptionPane.showMessageDialog(null,"Display the delete task: " + "Entry \"" + taskName + "\" successfully deleted");
        
    }

    public static void displayReport() {
        
        JOptionPane.showMessageDialog(null,"Display Report" );
        
        StringBuilder reportBuilder = new StringBuilder();
        
        // Iterating over the task list and collecting details
        for (Task task : taskList ) {
            reportBuilder.append(task.getprintTaskDetails()).append("\n\n"); // Append task details with spacing
             
        }
        
        //Displaying the task details that was not deleted
        JOptionPane.showMessageDialog(null, reportBuilder.toString(), "Task List", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Thank you for using EasyKanban!");
    }
    
    
/**********************End of Part 3 POE****************************************
********************************************************************************
********************************************************************************
*/ 
             
    
}
