package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_different_class() {
        ArrayList<String> arr = new ArrayList<String>();
        assert(!team.equals(arr));
    }

    @Test
    public void equals_compare_fields() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        Team team3 = new Team("not-test-team");
        Team team4 = new Team("not-test-team");

        ArrayList<String> team_names = new ArrayList<String>();
        team_names.add("Alice");
        ArrayList<String> not_team_names = new ArrayList<String>();
        not_team_names.add("Alice");
        not_team_names.add("Bob");

        team.setMembers(team_names);

        team1.setMembers(team_names);
        team2.setMembers(not_team_names);
        team3.setMembers(team_names);
        team4.setMembers(not_team_names);

        assert(team.equals(team1));
        assert(!team.equals(team2));
        assert(!team.equals(team3));
        assert(!team.equals(team4));
    }

    @Test
    public void hashCode_asserts_equal() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        Team team3 = new Team("not-test-team");
        Team team4 = new Team("not-test-team");

        ArrayList<String> team_names = new ArrayList<String>();
        team_names.add("Alice");
        ArrayList<String> not_team_names = new ArrayList<String>();
        not_team_names.add("Alice");
        not_team_names.add("Bob");

        team.setMembers(team_names);

        team1.setMembers(team_names);
        team2.setMembers(not_team_names);
        team3.setMembers(team_names);
        team4.setMembers(not_team_names);

        assert(team.hashCode() == team1.hashCode());
        assert(team.hashCode() != team2.hashCode());
        assert(team.hashCode() != team3.hashCode());
        assert(team.hashCode() != team4.hashCode());

        assert(team.hashCode() != (team.name.hashCode() & team.members.hashCode()));
    }
}
