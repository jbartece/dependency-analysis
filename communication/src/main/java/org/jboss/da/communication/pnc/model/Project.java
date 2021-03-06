package org.jboss.da.communication.pnc.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Project {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String issueTrackerUrl;

    @Getter
    @Setter
    private String projectUrl;

    @Getter
    @Setter
    private List<Integer> configurationIds;

    @Getter
    @Setter
    private String licenseId;

}
