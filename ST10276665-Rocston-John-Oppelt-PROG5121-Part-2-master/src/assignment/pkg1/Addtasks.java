package assignment.pkg1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Addtasks {

    public List<Task> tasks = new ArrayList<>();

    public Addtasks() {
        initializeTasks();
    }

    public static void easyKanBan() {
        Addtasks taskManager = new Addtasks();
        boolean running = true;

        while (running) {
            Object[] options = {
                "Add Task", "Show Report", "All tasks that are done", "Longest task", "Search by Task Name", "Search by Developer", "Delete Task", "Exit"
            };

            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome to EasyKanban:",
                    "Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0:
                    JOptionPane.showMessageDialog(null, "You are now in the add tasks section");
                    taskManager.addTasks();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, taskManager.showReport());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, taskManager.displayTasksWithStatusDone());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, taskManager.displayTaskWithLongestDuration());
                    break;
                case 4:
                    String taskName = JOptionPane.showInputDialog("Enter Task Name to search:");
                    List<Task> tasksByName = taskManager.searchTaskByName(taskName);

                    if (tasksByName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Task not found.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (Task task : tasksByName) {
                            sb.append(task.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;
                case 5:
                    String developerName = JOptionPane.showInputDialog("Enter Developer Name to search tasks:");
                    List<Task> tasksByDeveloper = taskManager.searchTasksByDeveloper(developerName);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Search results for Developer '").append(developerName).append("':\n");
                    for (Task task : tasksByDeveloper) {
                        sb.append("Task Name: ").append(task.getTaskName()).append(", ");
                        sb.append("Task Status: ").append(task.getTaskStatus()).append("\n");
                    }
                    if (tasksByDeveloper.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No tasks found for developer " + developerName + ".");
                    } else {
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;
                case 6:
                    String taskNameToDelete = JOptionPane.showInputDialog("Enter Task Name to delete:");
                    boolean isDeleted = taskManager.deleteTaskByName(taskNameToDelete);
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Task " + taskNameToDelete + " deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Task " + taskNameToDelete + " not found.");
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "See you next time!"); // Exit option
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice, exiting program.");
                    running = false;
                    break;
            }
        }
    }

    // Method to add multiple tasks
    public void addTasks() {
        int numTasksToAdd = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
        for (int i = 0; i < numTasksToAdd; i++) {
            String developer = JOptionPane.showInputDialog("Enter Developer Name for Task " + (i + 1) + ":");
            String taskName = JOptionPane.showInputDialog("Enter Task Name for Task " + (i + 1) + ":");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours) for Task " + (i + 1) + ":"));
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description for Task " + (i + 1) + ":");

            // Task status dropdown
            Object[] statusOptions = {"To Do", "In Progress", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(
                    null,
                    "Select Task Status for Task " + (i + 1) + ":",
                    "Task Status",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    statusOptions,
                    statusOptions[0]);

            // Generate Task ID
            String taskID = generateTaskID(taskName, developer);

            // Create a new Task object
            Task task = new Task(taskName, taskID, taskDescription, developer, taskDuration, taskStatus);
            tasks.add(task);

            JOptionPane.showMessageDialog(null, "Task " + taskName + " added successfully!\nTask ID: " + taskID);
        }
    }

    // Method to display tasks with status 'Done'
    public String displayTasksWithStatusDone() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tasks with Status 'Done':\n");
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTaskStatus().equalsIgnoreCase("Done")) {
                sb.append(task.toString()).append("\n");
                found = true;
            }
        }
        return found ? sb.toString() : "No tasks with status 'Done' found.";
    }

    // Method to display task with longest duration
    public String displayTaskWithLongestDuration() {
        Task longestTask = null;
        for (Task task : tasks) {
            if (longestTask == null || task.getTaskHours() > longestTask.getTaskHours()) {
                longestTask = task;
            }
        }
        if (longestTask != null) {
            return "Developer with Longest Task Duration: " + longestTask.getDeveloperName() +
                    "\nTask Duration: " + longestTask.getTaskHours() + " hours";
        } else {
            return "No tasks found.";
        }
    }

    // Method to search task by name
    public List<Task> searchTaskByName(String searchName) {
        List<Task> tasksByName = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(searchName)) {
                tasksByName.add(task);
            }
        }
        return tasksByName;
    }

    // Method to search tasks by developer
    public List<Task> searchTasksByDeveloper(String developerName) {
        List<Task> developerTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDeveloperName().equalsIgnoreCase(developerName)) {
                developerTasks.add(task);
            }
        }
        return developerTasks;
    }

    // Method to delete a task by name
    public boolean deleteTaskByName(String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskName().equalsIgnoreCase(taskName)) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    // Method to show report of all tasks
    public String showReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report of all tasks:\n");
        for (Task task : tasks) {
            sb.append(task.toString()).append("\n");
        }
        return sb.toString();
    }

    // Method to generate Task ID based on task name and developer
    protected String generateTaskID(String taskName, String developer) {
        String taskPrefix = taskName.substring(0, 2).toUpperCase(); // First two letters of task name in uppercase
        String developerSuffix = developer.substring(Math.max(0, developer.length() - 3)).toUpperCase(); // Last three letters of developer name in uppercase
        int taskNumber = tasks.size(); // Number of tasks currently in the list (0-based index)
        return taskPrefix + ":" + taskNumber + ":" + developerSuffix;
    }

    // Method to initialize tasks with given test data
    public void initializeTasks() {
        tasks.add(new Task("Create Login", generateTaskID("Create Login", "Mike Smith"), "Task 1 Description", "Mike Smith", 5, "To Do"));
        tasks.add(new Task("Create Add Features", generateTaskID("Create Add Features", "Edward Harrison"), "Task 2 Description", "Edward Harrison", 8, "Doing"));
        tasks.add(new Task("Create Reports", generateTaskID("Create Reports", "Samantha Paulson"), "Task 3 Description", "Samantha Paulson", 2, "Done"));
        tasks.add(new Task("Add Arrays", generateTaskID("Add Arrays", "Glenda Oberholzer"), "Task 4 Description", "Glenda Oberholzer", 11, "To Do"));
    }


}