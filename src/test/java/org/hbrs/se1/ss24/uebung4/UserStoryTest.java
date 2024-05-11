package org.hbrs.se1.ss24.uebung4;

import org.hbrs.se1.ss24.uebung4.storage.UserStoryStorageException;
import org.hbrs.se1.ss24.uebung4.taskuserstory.*;
import org.hbrs.se1.ss24.uebung4.storage.TaskStorage;
import org.hbrs.se1.ss24.uebung4.storage.UserStoryStorage;
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
        assertEquals("Item added", userStoryStorage.add(testStory));
        assertEquals(1, userStoryStorage.size());
        assertEquals("Item added", userStoryStorage.add(testStory2));
        assertEquals(2, userStoryStorage.size());
        assertEquals("The item with the Id:1 already exists", userStoryStorage.add(testStory));
        assertEquals(2, userStoryStorage.size());
        assertNull(userStoryStorage.get(9090));
        assertEquals(testStory,userStoryStorage.get(1));
        assertEquals(testStory2,userStoryStorage.get(2));
        assertEquals("""
                UserStory [id=1, description=description, prio=high, tasks=[]]\

                UserStory [id=2, description=description, prio=high, tasks=[]]
                """, userStoryStorage.toString());
    }

    @Test
    public void testTaskStorage() {
        assertEquals("Item added", taskStorage.add(testTask));
        assertEquals(1, taskStorage.size());
        assertEquals("Item added", taskStorage.add(testTask2));
        assertEquals(2, taskStorage.size());
        assertEquals("The item with the Id:1 already exists", taskStorage.add(testTask));
        assertEquals(2, taskStorage.size());
        assertNull(taskStorage.get(9090));
        assertEquals(testTask,taskStorage.get(1));
        assertEquals(testTask2,taskStorage.get(2));
        assertEquals("""
                Task [id=1, description=description]\

                Task [id=2, description=description]
                """, taskStorage.toString());
    }

    @Test
    public void testEmptyStorage(){
        UserStoryStorage emptyUserStorage = new UserStoryStorage();
        assertEquals(0,emptyUserStorage.size());
        assertEquals("", emptyUserStorage.toString());
    }

    @Test
    public void testSaveLoad(){
        UserStoryStorage emptyUserStorage = new UserStoryStorage();
        assertThrows(UserStoryStorageException.class, () -> emptyUserStorage.load("userStories.dat"));

        emptyUserStorage.add(testStory);
        emptyUserStorage.add(testStory2);
        try{
            emptyUserStorage.save("userStories.dat");
        }
        catch (UserStoryStorageException e){
            fail("exception while saving cardboard");
        }

        try {
            emptyUserStorage.load("userStories.dat");
            assertEquals(2, emptyUserStorage.size());
            assertEquals(testStory.toString(), emptyUserStorage.get(1).toString());
            assertEquals(testStory2.toString(), emptyUserStorage.get(2).toString());
        } catch (UserStoryStorageException e) {
            fail("Exception while loading CardBox");
        }

    }

}
