package org.hbrs.se1.ss24.uebung4;

import org.hbrs.se1.ss24.uebung4.businesslogic.Task;
import org.hbrs.se1.ss24.uebung4.businesslogic.UserStory;
import org.hbrs.se1.ss24.uebung4.businesslogic.UserStoryException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserStoryTest {

    @Test
    public void testUserStoryCreation() {
        UserStory userStory = new UserStory(1, "description", "high");
        assertNotNull(userStory);
    }

    @Test
    public void testTaskCreation() {
        Task task = new Task("description", 1);
        assertNotNull(task);
    }

    @Test
    public void testTaskId() {
        Task task = new Task("description", 1);
        assertEquals("T1", task.getId());
    }

    @Test
    public void testAddTaskToUserStory() throws UserStoryException {
        UserStory userStory = new UserStory(1, "description", "high");
        Task task = new Task("description", 1);
        userStory.addTask(task);
        assertEquals(1, userStory.getTasks().size());
    }

}
