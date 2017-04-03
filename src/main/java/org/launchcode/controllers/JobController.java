package org.launchcode.controllers;

import org.launchcode.models.Job;
import org.launchcode.models.data.JobData;
import org.launchcode.models.forms.JobForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {
        // TODO #1 - get the Job with the given ID and pass it into the view

        model.addAttribute("name",jobData.findById(id).getName());
        model.addAttribute("employer", jobData.findById(id).getEmployer());
        model.addAttribute("location", jobData.findById(id).getLocation());
        model.addAttribute("position", jobData.findById(id).getPositionType());
        model.addAttribute("skill", jobData.findById(id).getCoreCompetency());
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }


    @RequestMapping(value = "{id}")
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.

        if (errors.hasErrors()) {
            System.out.println("JC.53.hasErrors = " + errors.getAllErrors().toString());
            return "new-job";
        }

        Job newJob = new Job();
        int id = newJob.getId();

        newJob.setName(jobForm.getName());
        newJob.setEmployer(jobData.getEmployers().findById(jobForm.getEmployerId()));
        newJob.setLocation(jobData.getLocations().findById(jobForm.getLocationId()));
        newJob.setPositionType(jobData.getPositionTypes().findById(jobForm.getPositionTypeId()));
        newJob.setCoreCompetency(jobData.getCoreCompetencies().findById(jobForm.getCoreCompetencyId()));
        jobData.add(newJob);

        model.addAttribute("name", jobData.findById(id).getName());
        model.addAttribute("employer", jobData.findById(id).getEmployer());
        model.addAttribute("location", jobData.findById(id).getLocation());
        model.addAttribute("position", jobData.findById(id).getPositionType());
        model.addAttribute("skill", jobData.findById(id).getCoreCompetency());

        return "redirect:/job?id="+id;

    }
}
