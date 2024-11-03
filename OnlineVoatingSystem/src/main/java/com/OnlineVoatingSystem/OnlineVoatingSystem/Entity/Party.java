package com.OnlineVoatingSystem.OnlineVoatingSystem.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private long partyID;

    @Column(name = "party_name", nullable = false)
    private String partyName;

    @Column(name = "party_symbol", nullable = false)
    private String partySymbol;

    @Column(name = "foundation_year", nullable = false)
    private int foundationYear;

    @Column(name = "headquarters_location")
    private String headquartersLocation;

    @Column(name = "political_ideology")
    private String politicalIdeology;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL)
    private List<Candidate> candidates;

    // Getters and Setters
    public long getPartyID() {
        return partyID;
    }

    public void setPartyID(long partyID) {
        this.partyID = partyID;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartySymbol() {
        return partySymbol;
    }

    public void setPartySymbol(String partySymbol) {
        this.partySymbol = partySymbol;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getHeadquartersLocation() {
        return headquartersLocation;
    }

    public void setHeadquartersLocation(String headquartersLocation) {
        this.headquartersLocation = headquartersLocation;
    }

    public String getPoliticalIdeology() {
        return politicalIdeology;
    }

    public void setPoliticalIdeology(String politicalIdeology) {
        this.politicalIdeology = politicalIdeology;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

	@Override
	public String toString() {
		return "Party [partyID=" + partyID + ", partyName=" + partyName + ", partySymbol=" + partySymbol
				+ ", foundationYear=" + foundationYear + ", headquartersLocation=" + headquartersLocation
				+ ", politicalIdeology=" + politicalIdeology + ", candidates=" + candidates + ", getPartyID()="
				+ getPartyID() + ", getPartyName()=" + getPartyName() + ", getPartySymbol()=" + getPartySymbol()
				+ ", getFoundationYear()=" + getFoundationYear() + ", getHeadquartersLocation()="
				+ getHeadquartersLocation() + ", getPoliticalIdeology()=" + getPoliticalIdeology()
				+ ", getCandidates()=" + getCandidates() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Party(long partyID, String partyName, String partySymbol, int foundationYear, String headquartersLocation,
			String politicalIdeology, List<Candidate> candidates) {
		super();
		this.partyID = partyID;
		this.partyName = partyName;
		this.partySymbol = partySymbol;
		this.foundationYear = foundationYear;
		this.headquartersLocation = headquartersLocation;
		this.politicalIdeology = politicalIdeology;
		this.candidates = candidates;
	}

	public Party() {
		super();
		// TODO Auto-generated constructor stub
	}
}
