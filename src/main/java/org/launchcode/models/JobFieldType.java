package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public enum JobFieldType {

    EMPLOYER ("Employer"),
    LOCATION ("Location"),
    CORE_COMPETENCY ("Skill"),
    POSITION_TYPE ("Position Type"),
    ALL ("All");

    private final String name;

    JobFieldType(String name) {
        System.out.println("JFT.17.constructor.name = " + name);
        this.name = name;
    }

    public String getName() {
        System.out.println("JFT.22.getName = " + name);
        return name;
    }

}
