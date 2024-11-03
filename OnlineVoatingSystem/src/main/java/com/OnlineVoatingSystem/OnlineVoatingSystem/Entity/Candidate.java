package com.OnlineVoatingSystem.OnlineVoatingSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private long candidateID;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "political_experience")
    private int politicalExperience; // years in politics

	@Column(name = "education")
    private String education;

    @Column(name = "campaign_promises")
    private String campaignPromises;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    @ManyToOne
    @JoinColumn(name = "election_id", nullable = false)
    private Election election;

    // Getters and Setters
    public long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(long candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoliticalExperience() {
        return politicalExperience;
    }

    public void setPoliticalExperience(int politicalExperience) {
        this.politicalExperience = politicalExperience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCampaignPromises() {
        return campaignPromises;
    }

    public void setCampaignPromises(String campaignPromises) {
        this.campaignPromises = campaignPromises;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

	@Override
	public String toString() {
		return "Candidate [candidateID=" + candidateID + ", fullName=" + fullName + ", age=" + age
				+ ", politicalExperience=" + politicalExperience + ", education=" + education + ", campaignPromises="
				+ campaignPromises + ", party=" + party + ", election=" + election + ", getCandidateID()="
				+ getCandidateID() + ", getFullName()=" + getFullName() + ", getAge()=" + getAge()
				+ ", getPoliticalExperience()=" + getPoliticalExperience() + ", getEducation()=" + getEducation()
				+ ", getCampaignPromises()=" + getCampaignPromises() + ", getParty()=" + getParty() + ", getElection()="
				+ getElection() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	 public Candidate() {
			super();
			// TODO Auto-generated constructor stub
		}

	public Candidate(long candidateID, String fullName, int age, int politicalExperience, String education,
			String campaignPromises, Party party, Election election) {
		super();
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.age = age;
		this.politicalExperience = politicalExperience;
		this.education = education;
		this.campaignPromises = campaignPromises;
		this.party = party;
		this.election = election;
	}
}
