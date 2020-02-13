package ru.cubly.pet.analyzer.component;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job hddAnalyticsByModelJob;


    @RequestMapping("/analytics/{model}")
    public ResponseEntity<String> runJob(@PathVariable String model) {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("model", model)
                .addDate("date", new Date())
                .toJobParameters();
        try {
            JobExecution runnedJob = jobLauncher.run(hddAnalyticsByModelJob, jobParameters);
            return ResponseEntity.status(HttpStatus.OK).body(runnedJob.getJobId().toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
