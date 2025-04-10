package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Selena Z.", Developer.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s25-08", t.getName());
    }


    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Selena"),"Team should contain Selena");
        assertTrue(t.getMembers().contains("Hannah"),"Team should contain Hannah");
        assertTrue(t.getMembers().contains("Tiffany"),"Team should contain Tiffany");
        assertTrue(t.getMembers().contains("Rishik"),"Team should contain Rishik");
        assertTrue(t.getMembers().contains("Giovanni"),"Team should contain Giovanni");
        assertTrue(t.getMembers().contains("Nathan"),"Team should contain Nathan");
    }

    @Test
    public void getGithubId_returns_correctGithubId() {
        assertEquals("selenazeng1", Developer.getGithubId());
    }
}
