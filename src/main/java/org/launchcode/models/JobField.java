package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class JobField {

    private String value;
    private int id;
    private static int nextId = 1;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String aValue) {
        this();
        value = aValue;
//        System.out.println("JF.20 inside JobField constructor " + id + " " + value);
    }

    public boolean contains(String value) {
        return this.value.toLowerCase().contains(value.toLowerCase());
    }

    public String getValue() {
//        System.out.println("JF.27.getValue = " + value);
        return value;
    }

    public void setValue(String aValue) {
        System.out.println("JF.31.setValue = " + aValue);
        value = aValue;
    }

    public String toString() {
        return value;
    }

    public int getId() {
//        System.out.println("JF.41.getId = " + id);
        return id;
    }

    private void setId(int id) {
        System.out.println("JF.47.setId = " + id);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobField jobField = (JobField) o;
        System.out.println("JF.56.jobField.getId() = " + jobField.getId());
        return id == jobField.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

}
