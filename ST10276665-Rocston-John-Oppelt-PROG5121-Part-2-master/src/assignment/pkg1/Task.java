package assignment.pkg1;

public class Task {
    private String taskName;
    private String taskID;
    private String taskDescription;
    private String developerName;
    private int taskHours;
    private String taskStatus;

    public Task(String taskName, String taskID, String taskDescription, String developerName, int taskHours, String taskStatus) {
        this.taskName = taskName;
        this.taskID = taskID;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.taskHours = taskHours;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public int getTaskHours() {
        return taskHours;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    @Override
    public String toString() {
        return "Task Name: " + taskName + "\n"
                + "Task ID: " + taskID + "\n"
                + "Description: " + taskDescription + "\n"
                + "Developer: " + developerName + "\n"
                + "Task Hours: " + taskHours + "\n"
                + "Status: " + taskStatus + "\n";
    }
}
