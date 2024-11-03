package com.OnlineVoatingSystem.OnlineVoatingSystem.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "constituency")
public class Constituency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constituency_id")
    private long constituencyID;

    @Column(name = "constituency_name", nullable = false)
    private String constituencyName;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "population_size")
    private int populationSize;

    @Column(name = "voter_turnout")
    private double voterTurnout; // percentage of voters

    @OneToMany(mappedBy = "constituency", cascade = CascadeType.ALL)
    private List<Election> elections;

    // Getters and Setters
    public long getConstituencyID() {
        return constituencyID;
    }

    public void setConstituencyID(long constituencyID) {
        this.constituencyID = constituencyID;
    }

    public String getConstituencyName() {
        return constituencyName;
    }

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public double getVoterTurnout() {
        return voterTurnout;
    }

    public void setVoterTurnout(double voterTurnout) {
        this.voterTurnout = voterTurnout;
    }

    public List<Election> getElections() {
        return elections;
    }

    public void setElections(List<Election> elections) {
        this.elections = elections;
    }

	@Override
	public String toString() {
		return "Constituency [constituencyID=" + constituencyID + ", constituencyName=" + constituencyName + ", state="
				+ state + ", populationSize=" + populationSize + ", voterTurnout=" + voterTurnout + ", elections="
				+ elections + ", getConstituencyID()=" + getConstituencyID() + ", getConstituencyName()="
				+ getConstituencyName() + ", getState()=" + getState() + ", getPopulationSize()=" + getPopulationSize()
				+ ", getVoterTurnout()=" + getVoterTurnout() + ", getElections()=" + getElections() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Constituency(long constituencyID, String constituencyName, String state, int populationSize,
			double voterTurnout, List<Election> elections) {
		super();
		this.constituencyID = constituencyID;
		this.constituencyName = constituencyName;
		this.state = state;
		this.populationSize = populationSize;
		this.voterTurnout = voterTurnout;
		this.elections = elections;
	}

	public Constituency() {
		super();
		// TODO Auto-generated constructor stub
	}
}
