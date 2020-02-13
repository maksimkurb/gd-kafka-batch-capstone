package ru.cubly.pet.producer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "hdd.producer")
@RefreshScope
public class HddProducerProperties {
    private String inboundDir;
    private String workingDir;
    private String archiveDir;

    public String getInboundDir() {
        return inboundDir;
    }

    public void setInboundDir(String inboundDir) {
        this.inboundDir = inboundDir;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getArchiveDir() {
        return archiveDir;
    }

    public void setArchiveDir(String archiveDir) {
        this.archiveDir = archiveDir;
    }
}
