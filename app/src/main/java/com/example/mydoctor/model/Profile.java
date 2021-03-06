package com.example.mydoctor.model;

public class Profile {
    private String firstName;
    private String lastName;
    private String surname;
    private String dob;
    private String age;
    private String gender;
    private String nationality;
    private String nation_id;
    private String phoneNum;
    private String languages_fluent;
    private String county;
    private String locality;
    private String next_of_kin;
    private String guardian_id;
    private String guardian_firstName;
    private String guardian_lastName;
    private String guardian_phoneNum;
    private String guardian_locality;
    private String bloodGroup;
    private String bloodPressure;
    private String height;
    private String weight;
    private String existingMedCondition;
    private String hivStatus;

    public Profile(String firstName, String lastName, String surname, String dob, String age, String gender, String nationality, String nation_id, String phoneNum, String languages_fluent, String county, String locality, String next_of_kin, String guardian_id, String guardian_firstName, String guardian_lastName, String guardian_phoneNum, String guardian_locality, String bloodGroup, String bloodPressure, String height, String weight, String existingMedCondition, String hivStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.nation_id = nation_id;
        this.phoneNum = phoneNum;
        this.languages_fluent = languages_fluent;
        this.county = county;
        this.locality = locality;
        this.next_of_kin = next_of_kin;
        this.guardian_id = guardian_id;
        this.guardian_firstName = guardian_firstName;
        this.guardian_lastName = guardian_lastName;
        this.guardian_phoneNum = guardian_phoneNum;
        this.guardian_locality = guardian_locality;
        this.bloodGroup = bloodGroup;
        this.bloodPressure = bloodPressure;
        this.height = height;
        this.weight = weight;
        this.existingMedCondition = existingMedCondition;
        this.hivStatus = hivStatus;
    }

    public Profile() {
    }

    public void setGuardian_id(String guardian_id){
        this.guardian_id = guardian_id;
    }

    public String getGuardian_id(){
        return guardian_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNation_id() {
        return nation_id;
    }

    public void setNation_id(String nation_id) {
        this.nation_id = nation_id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLanguages_fluent() {
        return languages_fluent;
    }

    public void setLanguages_fluent(String languages_fluent) {
        this.languages_fluent = languages_fluent;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getNext_of_kin() {
        return next_of_kin;
    }

    public void setNext_of_kin(String next_of_kin) {
        this.next_of_kin = next_of_kin;
    }

    public String getGuardian_firstName() {
        return guardian_firstName;
    }

    public void setGuardian_firstName(String guardian_firstName) {
        this.guardian_firstName = guardian_firstName;
    }

    public String getGuardian_lastName() {
        return guardian_lastName;
    }

    public void setGuardian_lastName(String guardian_lastName) {
        this.guardian_lastName = guardian_lastName;
    }

    public String getGuardian_phoneNum() {
        return guardian_phoneNum;
    }

    public void setGuardian_phoneNum(String guardian_phoneNum) {
        this.guardian_phoneNum = guardian_phoneNum;
    }

    public String getGuardian_locality() {
        return guardian_locality;
    }

    public void setGuardian_locality(String guardian_locality) {
        this.guardian_locality = guardian_locality;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getExistingMedCondition() {
        return existingMedCondition;
    }

    public void setExistingMedCondition(String existingMedCondition) {
        this.existingMedCondition = existingMedCondition;
    }

    public String getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
    }
}
