package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_when_names_and_members_match() {
        Team team1 = new Team("team1");
        team1.addMember("Alice");
        team1.addMember("Bob");

        Team team2 = new Team("team1");
        team2.addMember("Alice");
        team2.addMember("Bob");

        assertTrue(team1.equals(team2));
    }

    @Test
    public void equals_returns_false_when_names_differ() {
        Team team1 = new Team("team1");
        team1.addMember("Alice");

        Team team2 = new Team("team2");
        team2.addMember("Alice");

        assertFalse(team1.equals(team2));
    }

    @Test
    public void equals_returns_false_when_members_differ() {
        Team team1 = new Team("team1");
        team1.addMember("Alice");

        Team team2 = new Team("team1");
        team2.addMember("Bob");

        assertFalse(team1.equals(team2));
    }

    @Test
    public void equals_returns_false_when_comparing_with_null() {
        Team team1 = new Team("team1");
        assertFalse(team1.equals(null));
    }

    @Test
    public void equals_returns_false_when_comparing_with_different_type() {
        Team team1 = new Team("team1");
        assertFalse(team1.equals("not a team"));
    }

    @Test
    public void equals_returns_true_when_comparing_same_object() {
        Team team1 = new Team("team1");
        assertTrue(team1.equals(team1));
    }

    @Test
    public void hashCode_returns_same_value_for_equal_teams() {
        Team team1 = new Team("team1");
        team1.addMember("Alice");
        team1.addMember("Bob");

        Team team2 = new Team("team1");
        team2.addMember("Alice");
        team2.addMember("Bob");

        assertEquals(team1.hashCode(), team2.hashCode(), "Equal teams should have equal hash codes");
    }
}
