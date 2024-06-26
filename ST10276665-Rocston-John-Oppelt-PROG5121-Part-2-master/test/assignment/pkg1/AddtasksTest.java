package assignment.pkg1;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AddtasksTest {

    private Addtasks addtasks;

    @Before
    public void setUp() {
        addtasks = new Addtasks();
        addtasks.initializeTasks(); // Initialize tasks with test data
    }

    @Test
    public void testDeveloperArrayCorrectlyPopulated() {
        List<Task> tasks = addtasks.searchTasksByDeveloper("Mike Smith");
        assertEquals(2, tasks.size());
        assertEquals("Mike Smith", tasks.get(0).getDeveloperName());

        tasks = addtasks.searchTasksByDeveloper("Edward Harrison");
        assertEquals(2, tasks.size());
        assertEquals("Edward Harrison", tasks.get(0).getDeveloperName());

        tasks = addtasks.searchTasksByDeveloper("Samantha Paulson");
        assertEquals(2, tasks.size());
        assertEquals("Samantha Paulson", tasks.get(0).getDeveloperName());

        tasks = addtasks.searchTasksByDeveloper("Glenda Oberholzer");
        assertEquals(2, tasks.size());
        assertEquals("Glenda Oberholzer", tasks.get(0).getDeveloperName());
    }

    @Test
    public void testDisplayDeveloperAndDurationForLongestTask() {
        String result = addtasks.displayTaskWithLongestDuration();
        assertEquals("Developer with Longest Task Duration: Glenda Oberholzer\nTask Duration: 11 hours", result);
    }

    @Test
    public void testSearchTaskByName() {
        List<Task> tasks = addtasks.searchTaskByName("Create Login");
        assertEquals(2, tasks.size());
        assertEquals("Mike Smith", tasks.get(0).getDeveloperName());
        assertEquals("Create Login", tasks.get(0).getTaskName());
    }

    @Test
    public void testSearchTasksByDeveloper() {
        List<Task> tasks = addtasks.searchTasksByDeveloper("Samantha Paulson");
        assertEquals(2, tasks.size());
        assertEquals("Create Reports", tasks.get(0).getTaskName());
    }

    @Test
    public void testDeleteTaskByName() {
        assertTrue(addtasks.deleteTaskByName("Create Reports"));
        List<Task> tasks = addtasks.searchTaskByName("Create Reports");
        assertEquals(1, tasks.size());
    }

    @Test
    public void testShowReport() {
        String report = addtasks.showReport();
        assertTrue(report.contains("Create Login"));
        assertTrue(report.contains("Create Add Features"));
        assertTrue(report.contains("Create Reports"));
        assertTrue(report.contains("Add Arrays"));
    }
}
