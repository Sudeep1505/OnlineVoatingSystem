package com.OnlineVoatingSystem.OnlineVoatingSystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "voter")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voter_id")
    private long voterID;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone_number", nullable = false, unique = true)
    private long phoneNumber;

    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalID;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "voter_type", nullable = false)
    private String voterType;

    @OneToMany(mappedBy = "voter", cascade = CascadeType.ALL)
    private List<Vote> votes;

    // Getters and Setters
    public long getVoterID() {
        return voterID;
    }

    public void setVoterID(long voterID) {
        this.voterID = voterID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVoterType() {
        return voterType;
    }

    public void setVoterType(String voterType) {
        this.voterType = voterType;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    

	public Voter(long voterID, String fullName, LocalDate dateOfBirth, String gender, long phoneNumber,
			String nationalID, LocalDate registrationDate, String status, String voterType, List<Vote> votes) {
		super();
		this.voterID = voterID;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.nationalID = nationalID;
		this.registrationDate = registrationDate;
		this.status = status;
		this.voterType = voterType;
		this.votes = votes;
	}

	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Voter [voterID=" + voterID + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + ", nationalID=" + nationalID + ", registrationDate="
				+ registrationDate + ", status=" + status + ", voterType=" + voterType + ", votes=" + votes
				+ ", getVoterID()=" + getVoterID() + ", getFullName()=" + getFullName() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getGender()=" + getGender() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getNationalID()=" + getNationalID() + ", getRegistrationDate()=" + getRegistrationDate()
				+ ", getStatus()=" + getStatus() + ", getVoterType()=" + getVoterType() + ", getVotes()=" + getVotes()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
