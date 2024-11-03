package com.OnlineVoatingSystem.OnlineVoatingSystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private long voteID;

    @Column(name = "voting_time", nullable = false)
    private LocalDateTime votingTime;

    @Column(name = "voting_location", nullable = false)
    private String votingLocation;

    @ManyToOne
    @JoinColumn(name = "voter_id", nullable = false)
    private Voter voter;

    @ManyToOne
    @JoinColumn(name = "election_id", nullable = false)
    private Election election;

    @Column(name = "candidate_id", nullable = false)
    private long candidateID;

    // Getters and Setters
    public long getVoteID() {
        return voteID;
    }

    public void setVoteID(long voteID) {
        this.voteID = voteID;
    }

    public LocalDateTime getVotingTime() {
        return votingTime;
    }

    public void setVotingTime(LocalDateTime votingTime) {
        this.votingTime = votingTime;
    }

    public String getVotingLocation() {
        return votingLocation;
    }

    public void setVotingLocation(String votingLocation) {
        this.votingLocation = votingLocation;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(long candidateID) {
        this.candidateID = candidateID;
    }

	@Override
	public String toString() {
		return "Vote [voteID=" + voteID + ", votingTime=" + votingTime + ", votingLocation=" + votingLocation
				+ ", voter=" + voter + ", election=" + election + ", candidateID=" + candidateID + ", getVoteID()="
				+ getVoteID() + ", getVotingTime()=" + getVotingTime() + ", getVotingLocation()=" + getVotingLocation()
				+ ", getVoter()=" + getVoter() + ", getElection()=" + getElection() + ", getCandidateID()="
				+ getCandidateID() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Vote(long voteID, LocalDateTime votingTime, String votingLocation, Voter voter, Election election,
			long candidateID) {
		super();
		this.voteID = voteID;
		this.votingTime = votingTime;
		this.votingLocation = votingLocation;
		this.voter = voter;
		this.election = election;
		this.candidateID = candidateID;
	}

	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
