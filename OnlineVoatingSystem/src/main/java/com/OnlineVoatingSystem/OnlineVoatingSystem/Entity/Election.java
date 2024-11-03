package com.OnlineVoatingSystem.OnlineVoatingSystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "election")
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "election_id")
    private long electionID;

    @Column(name = "election_name", nullable = false)
    private String electionName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "election_type", nullable = false)
    private String electionType;

    @Column(name = "description", nullable = false)
    private String description;

    // One-to-Many relationship with Vote
    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL)
    private List<Vote> votes;

    // One-to-Many relationship with Candidate
    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL)
    private List<Candidate> candidates;

    // Many-to-One relationship with Constituency
    @ManyToOne
    @JoinColumn(name = "constituency_id", nullable = false)
    private Constituency constituency;

    // Getters and Setters
    public long getElectionID() {
        return electionID;
    }

    public void setElectionID(long electionID) {
        this.electionID = electionID;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getElectionType() {
        return electionType;
    }

    public void setElectionType(String electionType) {
        this.electionType = electionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    // Constructors

    public Election() {
        super();
    }

    public Election(long electionID, String electionName, LocalDate startDate, LocalDate endDate, String electionType,
                    String description, List<Vote> votes, List<Candidate> candidates, Constituency constituency) {
        this.electionID = electionID;
        this.electionName = electionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.electionType = electionType;
        this.description = description;
        this.votes = votes;
        this.candidates = candidates;
        this.constituency = constituency;
    }

    // toString Method

    @Override
    public String toString() {
        return "Election [electionID=" + electionID + ", electionName=" + electionName + ", startDate=" + startDate
                + ", endDate=" + endDate + ", electionType=" + electionType + ", description=" + description
                + ", votes=" + votes + ", candidates=" + candidates + ", constituency=" + constituency + "]";
    }
}
