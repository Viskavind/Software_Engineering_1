package org.hbrs.se1.ss24.uebung4;

import org.hbrs.se1.ss24.uebung4.businesslogic.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserStoryTest {

    UserStoryStorage userStoryStorage;
    TaskStorage taskStorage;
    UserStory testStory;
    UserStory testStory2;
    Task testTask;
    Task testTask2;

    @BeforeEach
    public void setUp() {
        userStoryStorage = new UserStoryStorage();
        taskStorage = new TaskStorage();
        testStory = new UserStory(1, "description", "high");
        testStory2 = new UserStory(2, "description", "high");
        testTask = new Task("description", 1);
        testTask2 = new Task("description", 2);
    }

    @Test
    public void testUserStoryCreation() {
        assertNotNull(testStory);
        assertEquals(1, testStory.getId());
        assertEquals("UserStory [id=1, description=description, prio=high, tasks=[]]", testStory.toString());
    }

    @Test
    public void testUserStoryTasks(){
        testStory.addTask(testTask);
        assertNotNull(testStory.getTasks());
        assertEquals("[Task [id=1, description=description]]", testStory.getTasks().toString());
    }

    @Test
    public void testTaskCreation() {
        assertNotNull(testTask);
        assertEquals(1,testTask.getId());
        assertEquals("Task [id=1, description=description]", testTask.toString());
    }

    @Test
    public void testUserStoryStorage() {
        assertEquals("User Story wurde hinzugefügt", userStoryStorage.addUserStory(testStory));
        assertEquals(1, userStoryStorage.size());
        assertEquals("User Story wurde hinzugefügt", userStoryStorage.addUserStory(testStory2));
        assertEquals(2, userStoryStorage.size());
        assertEquals("Die UserStory mit der Id:1 existiert bereits", userStoryStorage.addUserStory(testStory));
        assertEquals(2, userStoryStorage.size());
        assertNull(userStoryStorage.getUserStory(9090));
        assertEquals(testStory,userStoryStorage.getUserStory(1));
        assertEquals(testStory2,userStoryStorage.getUserStory(2));
        assertEquals("UserStory [id=1, description=description, prio=high, tasks=[]]" +
                "\nUserStory [id=2, description=description, prio=high, tasks=[]]\n", userStoryStorage.toString());
    }

    @Test
    public void testTaskStorage() {
        assertEquals("Task added", taskStorage.addTask(testTask));
        assertEquals(1, taskStorage.size());
        assertEquals("Task added", taskStorage.addTask(testTask2));
        assertEquals(2, taskStorage.size());
        assertEquals("Task already exists", taskStorage.addTask(testTask));
        assertEquals(2, taskStorage.size());
        assertNull(taskStorage.getTasks(9090));
        assertEquals(testTask,taskStorage.getTasks(1));
        assertEquals(testTask2,taskStorage.getTasks(2));
        assertEquals("Task [id=1, description=description]" +
                "\nTask [id=2, description=description]\n", taskStorage.toString());
    }

}
