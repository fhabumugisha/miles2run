package org.miles2run.domain.entities;

public enum Gender {
    MALE("MALE"), FEMALE("FEMALE"), OTHER("OTHER");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender fromStringToGender(String genderStr) {
        Gender[] values = Gender.values();
        for (Gender gender : values) {
            if (gender.gender.equals(genderStr)) {
                return gender;
            }
        }
        return null;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return this.gender != null ? this.gender.toLowerCase() : null;
    }
}
