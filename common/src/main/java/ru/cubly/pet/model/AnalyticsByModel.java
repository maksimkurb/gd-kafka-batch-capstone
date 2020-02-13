package ru.cubly.pet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "analytics_by_model")
public class AnalyticsByModel implements HddInfo, Serializable {
    @Column(name = "model")
    @JsonProperty("model")
    @Id
    protected String model;

    @Column(name = "total_events")
    @JsonProperty("total_events")
    private long totalEvents;

    @Column(name = "capacity_bytes")
    @JsonProperty("capacity_bytes")
    protected Long capacityBytes;

    @Column(name = "failure")
    @JsonProperty("failure")
    protected Long failure;

    @Column(name = "smart_1")
    @JsonProperty("smart_1")
    protected Long rawReadErrorRate;

    @Column(name = "smart_2")
    @JsonProperty("smart_2")
    protected Long throughputPerformance;

    @Column(name = "smart_3")
    @JsonProperty("smart_3")
    protected Long spinUpTime;

    @Column(name = "smart_4")
    @JsonProperty("smart_4")
    protected Long startStopCount;

    @Column(name = "smart_5")
    @JsonProperty("smart_5")
    protected Long reallocatedSectorsCount;

    @Column(name = "smart_7")
    @JsonProperty("smart_7")
    protected Long seekErrorRate;

    @Column(name = "smart_8")
    @JsonProperty("smart_8")
    protected Long seekTimePerformance;

    @Column(name = "smart_9")
    @JsonProperty("smart_9")
    protected Long powerOnTimeCount;

    @Column(name = "smart_10")
    @JsonProperty("smart_10")
    protected Long spinUpRetryCount;

    @Column(name = "smart_11")
    @JsonProperty("smart_11")
    protected Long recalibrationRetries;

    @Column(name = "smart_12")
    @JsonProperty("smart_12")
    protected Long devicePowerCycleCount;

    @Column(name = "smart_13")
    @JsonProperty("smart_13")
    protected Long softReadErrorRate;

    @Column(name = "smart_15")
    @JsonProperty("smart_15")
    protected Long unknown15;

    @Column(name = "smart_16")
    @JsonProperty("smart_16")
    protected Long unknown16;

    @Column(name = "smart_17")
    @JsonProperty("smart_17")
    protected Long unknown17;

    @Column(name = "smart_22")
    @JsonProperty("smart_22")
    protected Long unknown22;

    @Column(name = "smart_23")
    @JsonProperty("smart_23")
    protected Long unknown23;

    @Column(name = "smart_24")
    @JsonProperty("smart_24")
    protected Long unknown24;

    @Column(name = "smart_168")
    @JsonProperty("smart_168")
    protected Long unknown168;

    @Column(name = "smart_170")
    @JsonProperty("smart_170")
    protected Long reversedBlockCount;

    @Column(name = "smart_173")
    @JsonProperty("smart_173")
    protected Long wearLevellerWorstEraseCount;

    @Column(name = "smart_174")
    @JsonProperty("smart_174")
    protected Long unexpectedPowerLoss;

    @Column(name = "smart_177")
    @JsonProperty("smart_177")
    protected Long wearLevellingCount;

    @Column(name = "smart_179")
    @JsonProperty("smart_179")
    protected Long usedReversedBlockCount;

    @Column(name = "smart_181")
    @JsonProperty("smart_181")
    protected Long programFailCount;

    @Column(name = "smart_182")
    @JsonProperty("smart_182")
    protected Long eraseFailCount;

    @Column(name = "smart_183")
    @JsonProperty("smart_183")
    protected Long sataDownshifts;

    @Column(name = "smart_184")
    @JsonProperty("smart_184")
    protected Long endToEndError;

    @Column(name = "smart_187")
    @JsonProperty("smart_187")
    protected Long reportedUncErrors;

    @Column(name = "smart_188")
    @JsonProperty("smart_188")
    protected Long commandTimeout;

    @Column(name = "smart_189")
    @JsonProperty("smart_189")
    protected Long highFlyWrites;

    @Column(name = "smart_190")
    @JsonProperty("smart_190")
    protected Long airflowTemperature;

    @Column(name = "smart_191")
    @JsonProperty("smart_191")
    protected Long gSenseErrorRate;

    @Column(name = "smart_192")
    @JsonProperty("smart_192")
    protected Long powerOffRetractCount;

    @Column(name = "smart_193")
    @JsonProperty("smart_193")
    protected Long loadUnloadCycle;

    @Column(name = "smart_194")
    @JsonProperty("smart_194")
    protected Long hdaTemperature;

    @Column(name = "smart_195")
    @JsonProperty("smart_195")
    protected Long hardwareEccRecovered;

    @Column(name = "smart_196")
    @JsonProperty("smart_196")
    protected Long reallocationEventsCount;

    @Column(name = "smart_197")
    @JsonProperty("smart_197")
    protected Long currentPendingSectorCount;

    @Column(name = "smart_198")
    @JsonProperty("smart_198")
    protected Long uncorrectableSectorCount;

    @Column(name = "smart_199")
    @JsonProperty("smart_199")
    protected Long ultraDmaCrcErrorCount;

    @Column(name = "smart_200")
    @JsonProperty("smart_200")
    protected Long writeErrorRate;

    @Column(name = "smart_201")
    @JsonProperty("smart_201")
    protected Long taCounterDetected;

    @Column(name = "smart_218")
    @JsonProperty("smart_218")
    protected Long unknown218;

    @Column(name = "smart_220")
    @JsonProperty("smart_220")
    protected Long diskShift;

    @Column(name = "smart_222")
    @JsonProperty("smart_222")
    protected Long loadedHours;

    @Column(name = "smart_223")
    @JsonProperty("smart_223")
    protected Long loadUnloadRetryCount;

    @Column(name = "smart_224")
    @JsonProperty("smart_224")
    protected Long loadFriction;

    @Column(name = "smart_225")
    @JsonProperty("smart_225")
    protected Long loadUnloadCycleCount;

    @Column(name = "smart_226")
    @JsonProperty("smart_226")
    protected Long loadInTime;

    @Column(name = "smart_231")
    @JsonProperty("smart_231")
    protected Long lifeLeft;

    @Column(name = "smart_232")
    @JsonProperty("smart_232")
    protected Long enduranceRemaining;

    @Column(name = "smart_233")
    @JsonProperty("smart_233")
    protected Long mediaWearoutIndicator;

    @Column(name = "smart_235")
    @JsonProperty("smart_235")
    protected Long goodBlockCountAndMaximumEraseCount;

    @Column(name = "smart_240")
    @JsonProperty("smart_240")
    protected Long headFlyingHours;

    @Column(name = "smart_241")
    @JsonProperty("smart_241")
    protected Long totalLbaWritten;

    @Column(name = "smart_242")
    @JsonProperty("smart_242")
    protected Long totalLbaRead;

    @Column(name = "smart_250")
    @JsonProperty("smart_250")
    protected Long readErrorRetry;

    @Column(name = "smart_251")
    @JsonProperty("smart_251")
    protected Long minimumSparesRemaining;

    @Column(name = "smart_252")
    @JsonProperty("smart_252")
    protected Long newlyAddedFlashBlock;

    @Column(name = "smart_254")
    @JsonProperty("smart_254")
    protected Long freeFallProtection;

    @Column(name = "smart_255")
    @JsonProperty("smart_255")
    protected Long unknown255;

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    public long getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(long totalEvents) {
        this.totalEvents = totalEvents;
    }

    @Override
    public Long getCapacityBytes() {
        return capacityBytes;
    }

    @Override
    public void setCapacityBytes(Long capacityBytes) {
        this.capacityBytes = capacityBytes;
    }

    @Override
    public Long getFailure() {
        return failure;
    }

    @Override
    public void setFailure(Long failure) {
        this.failure = failure;
    }

    @Override
    public Long getRawReadErrorRate() {
        return rawReadErrorRate;
    }

    @Override
    public void setRawReadErrorRate(Long rawReadErrorRate) {
        this.rawReadErrorRate = rawReadErrorRate;
    }

    @Override
    public Long getThroughputPerformance() {
        return throughputPerformance;
    }

    @Override
    public void setThroughputPerformance(Long throughputPerformance) {
        this.throughputPerformance = throughputPerformance;
    }

    @Override
    public Long getSpinUpTime() {
        return spinUpTime;
    }

    @Override
    public void setSpinUpTime(Long spinUpTime) {
        this.spinUpTime = spinUpTime;
    }

    @Override
    public Long getStartStopCount() {
        return startStopCount;
    }

    @Override
    public void setStartStopCount(Long startStopCount) {
        this.startStopCount = startStopCount;
    }

    @Override
    public Long getReallocatedSectorsCount() {
        return reallocatedSectorsCount;
    }

    @Override
    public void setReallocatedSectorsCount(Long reallocatedSectorsCount) {
        this.reallocatedSectorsCount = reallocatedSectorsCount;
    }

    @Override
    public Long getSeekErrorRate() {
        return seekErrorRate;
    }

    @Override
    public void setSeekErrorRate(Long seekErrorRate) {
        this.seekErrorRate = seekErrorRate;
    }

    @Override
    public Long getSeekTimePerformance() {
        return seekTimePerformance;
    }

    @Override
    public void setSeekTimePerformance(Long seekTimePerformance) {
        this.seekTimePerformance = seekTimePerformance;
    }

    @Override
    public Long getPowerOnTimeCount() {
        return powerOnTimeCount;
    }

    @Override
    public void setPowerOnTimeCount(Long powerOnTimeCount) {
        this.powerOnTimeCount = powerOnTimeCount;
    }

    @Override
    public Long getSpinUpRetryCount() {
        return spinUpRetryCount;
    }

    @Override
    public void setSpinUpRetryCount(Long spinUpRetryCount) {
        this.spinUpRetryCount = spinUpRetryCount;
    }

    @Override
    public Long getRecalibrationRetries() {
        return recalibrationRetries;
    }

    @Override
    public void setRecalibrationRetries(Long recalibrationRetries) {
        this.recalibrationRetries = recalibrationRetries;
    }

    @Override
    public Long getDevicePowerCycleCount() {
        return devicePowerCycleCount;
    }

    @Override
    public void setDevicePowerCycleCount(Long devicePowerCycleCount) {
        this.devicePowerCycleCount = devicePowerCycleCount;
    }

    @Override
    public Long getSoftReadErrorRate() {
        return softReadErrorRate;
    }

    @Override
    public void setSoftReadErrorRate(Long softReadErrorRate) {
        this.softReadErrorRate = softReadErrorRate;
    }

    @Override
    public Long getUnknown15() {
        return unknown15;
    }

    @Override
    public void setUnknown15(Long unknown15) {
        this.unknown15 = unknown15;
    }

    @Override
    public Long getUnknown16() {
        return unknown16;
    }

    @Override
    public void setUnknown16(Long unknown16) {
        this.unknown16 = unknown16;
    }

    @Override
    public Long getUnknown17() {
        return unknown17;
    }

    @Override
    public void setUnknown17(Long unknown17) {
        this.unknown17 = unknown17;
    }

    @Override
    public Long getUnknown22() {
        return unknown22;
    }

    @Override
    public void setUnknown22(Long unknown22) {
        this.unknown22 = unknown22;
    }

    @Override
    public Long getUnknown23() {
        return unknown23;
    }

    @Override
    public void setUnknown23(Long unknown23) {
        this.unknown23 = unknown23;
    }

    @Override
    public Long getUnknown24() {
        return unknown24;
    }

    @Override
    public void setUnknown24(Long unknown24) {
        this.unknown24 = unknown24;
    }

    @Override
    public Long getUnknown168() {
        return unknown168;
    }

    @Override
    public void setUnknown168(Long unknown168) {
        this.unknown168 = unknown168;
    }

    @Override
    public Long getReversedBlockCount() {
        return reversedBlockCount;
    }

    @Override
    public void setReversedBlockCount(Long reversedBlockCount) {
        this.reversedBlockCount = reversedBlockCount;
    }

    @Override
    public Long getWearLevellerWorstEraseCount() {
        return wearLevellerWorstEraseCount;
    }

    @Override
    public void setWearLevellerWorstEraseCount(Long wearLevellerWorstEraseCount) {
        this.wearLevellerWorstEraseCount = wearLevellerWorstEraseCount;
    }

    @Override
    public Long getUnexpectedPowerLoss() {
        return unexpectedPowerLoss;
    }

    @Override
    public void setUnexpectedPowerLoss(Long unexpectedPowerLoss) {
        this.unexpectedPowerLoss = unexpectedPowerLoss;
    }

    @Override
    public Long getWearLevellingCount() {
        return wearLevellingCount;
    }

    @Override
    public void setWearLevellingCount(Long wearLevellingCount) {
        this.wearLevellingCount = wearLevellingCount;
    }

    @Override
    public Long getUsedReversedBlockCount() {
        return usedReversedBlockCount;
    }

    @Override
    public void setUsedReversedBlockCount(Long usedReversedBlockCount) {
        this.usedReversedBlockCount = usedReversedBlockCount;
    }

    @Override
    public Long getProgramFailCount() {
        return programFailCount;
    }

    @Override
    public void setProgramFailCount(Long programFailCount) {
        this.programFailCount = programFailCount;
    }

    @Override
    public Long getEraseFailCount() {
        return eraseFailCount;
    }

    @Override
    public void setEraseFailCount(Long eraseFailCount) {
        this.eraseFailCount = eraseFailCount;
    }

    @Override
    public Long getSataDownshifts() {
        return sataDownshifts;
    }

    @Override
    public void setSataDownshifts(Long sataDownshifts) {
        this.sataDownshifts = sataDownshifts;
    }

    @Override
    public Long getEndToEndError() {
        return endToEndError;
    }

    @Override
    public void setEndToEndError(Long endToEndError) {
        this.endToEndError = endToEndError;
    }

    @Override
    public Long getReportedUncErrors() {
        return reportedUncErrors;
    }

    @Override
    public void setReportedUncErrors(Long reportedUncErrors) {
        this.reportedUncErrors = reportedUncErrors;
    }

    @Override
    public Long getCommandTimeout() {
        return commandTimeout;
    }

    @Override
    public void setCommandTimeout(Long commandTimeout) {
        this.commandTimeout = commandTimeout;
    }

    @Override
    public Long getHighFlyWrites() {
        return highFlyWrites;
    }

    @Override
    public void setHighFlyWrites(Long highFlyWrites) {
        this.highFlyWrites = highFlyWrites;
    }

    @Override
    public Long getAirflowTemperature() {
        return airflowTemperature;
    }

    @Override
    public void setAirflowTemperature(Long airflowTemperature) {
        this.airflowTemperature = airflowTemperature;
    }

    public Long getGSenseErrorRate() {
        return gSenseErrorRate;
    }

    public void setGSenseErrorRate(Long gSenseErrorRate) {
        this.gSenseErrorRate = gSenseErrorRate;
    }

    @Override
    public Long getPowerOffRetractCount() {
        return powerOffRetractCount;
    }

    @Override
    public void setPowerOffRetractCount(Long powerOffRetractCount) {
        this.powerOffRetractCount = powerOffRetractCount;
    }

    @Override
    public Long getLoadUnloadCycle() {
        return loadUnloadCycle;
    }

    @Override
    public void setLoadUnloadCycle(Long loadUnloadCycle) {
        this.loadUnloadCycle = loadUnloadCycle;
    }

    @Override
    public Long getHdaTemperature() {
        return hdaTemperature;
    }

    @Override
    public void setHdaTemperature(Long hdaTemperature) {
        this.hdaTemperature = hdaTemperature;
    }

    @Override
    public Long getHardwareEccRecovered() {
        return hardwareEccRecovered;
    }

    @Override
    public void setHardwareEccRecovered(Long hardwareEccRecovered) {
        this.hardwareEccRecovered = hardwareEccRecovered;
    }

    @Override
    public Long getReallocationEventsCount() {
        return reallocationEventsCount;
    }

    @Override
    public void setReallocationEventsCount(Long reallocationEventsCount) {
        this.reallocationEventsCount = reallocationEventsCount;
    }

    @Override
    public Long getCurrentPendingSectorCount() {
        return currentPendingSectorCount;
    }

    @Override
    public void setCurrentPendingSectorCount(Long currentPendingSectorCount) {
        this.currentPendingSectorCount = currentPendingSectorCount;
    }

    @Override
    public Long getUncorrectableSectorCount() {
        return uncorrectableSectorCount;
    }

    @Override
    public void setUncorrectableSectorCount(Long uncorrectableSectorCount) {
        this.uncorrectableSectorCount = uncorrectableSectorCount;
    }

    @Override
    public Long getUltraDmaCrcErrorCount() {
        return ultraDmaCrcErrorCount;
    }

    @Override
    public void setUltraDmaCrcErrorCount(Long ultraDmaCrcErrorCount) {
        this.ultraDmaCrcErrorCount = ultraDmaCrcErrorCount;
    }

    @Override
    public Long getWriteErrorRate() {
        return writeErrorRate;
    }

    @Override
    public void setWriteErrorRate(Long writeErrorRate) {
        this.writeErrorRate = writeErrorRate;
    }

    @Override
    public Long getTaCounterDetected() {
        return taCounterDetected;
    }

    @Override
    public void setTaCounterDetected(Long taCounterDetected) {
        this.taCounterDetected = taCounterDetected;
    }

    @Override
    public Long getUnknown218() {
        return unknown218;
    }

    @Override
    public void setUnknown218(Long unknown218) {
        this.unknown218 = unknown218;
    }

    @Override
    public Long getDiskShift() {
        return diskShift;
    }

    @Override
    public void setDiskShift(Long diskShift) {
        this.diskShift = diskShift;
    }

    @Override
    public Long getLoadedHours() {
        return loadedHours;
    }

    @Override
    public void setLoadedHours(Long loadedHours) {
        this.loadedHours = loadedHours;
    }

    @Override
    public Long getLoadUnloadRetryCount() {
        return loadUnloadRetryCount;
    }

    @Override
    public void setLoadUnloadRetryCount(Long loadUnloadRetryCount) {
        this.loadUnloadRetryCount = loadUnloadRetryCount;
    }

    @Override
    public Long getLoadFriction() {
        return loadFriction;
    }

    @Override
    public void setLoadFriction(Long loadFriction) {
        this.loadFriction = loadFriction;
    }

    @Override
    public Long getLoadUnloadCycleCount() {
        return loadUnloadCycleCount;
    }

    @Override
    public void setLoadUnloadCycleCount(Long loadUnloadCycleCount) {
        this.loadUnloadCycleCount = loadUnloadCycleCount;
    }

    @Override
    public Long getLoadInTime() {
        return loadInTime;
    }

    @Override
    public void setLoadInTime(Long loadInTime) {
        this.loadInTime = loadInTime;
    }

    @Override
    public Long getLifeLeft() {
        return lifeLeft;
    }

    @Override
    public void setLifeLeft(Long lifeLeft) {
        this.lifeLeft = lifeLeft;
    }

    @Override
    public Long getEnduranceRemaining() {
        return enduranceRemaining;
    }

    @Override
    public void setEnduranceRemaining(Long enduranceRemaining) {
        this.enduranceRemaining = enduranceRemaining;
    }

    @Override
    public Long getMediaWearoutIndicator() {
        return mediaWearoutIndicator;
    }

    @Override
    public void setMediaWearoutIndicator(Long mediaWearoutIndicator) {
        this.mediaWearoutIndicator = mediaWearoutIndicator;
    }

    @Override
    public Long getGoodBlockCountAndMaximumEraseCount() {
        return goodBlockCountAndMaximumEraseCount;
    }

    @Override
    public void setGoodBlockCountAndMaximumEraseCount(Long goodBlockCountAndMaximumEraseCount) {
        this.goodBlockCountAndMaximumEraseCount = goodBlockCountAndMaximumEraseCount;
    }

    @Override
    public Long getHeadFlyingHours() {
        return headFlyingHours;
    }

    @Override
    public void setHeadFlyingHours(Long headFlyingHours) {
        this.headFlyingHours = headFlyingHours;
    }

    @Override
    public Long getTotalLbaWritten() {
        return totalLbaWritten;
    }

    @Override
    public void setTotalLbaWritten(Long totalLbaWritten) {
        this.totalLbaWritten = totalLbaWritten;
    }

    @Override
    public Long getTotalLbaRead() {
        return totalLbaRead;
    }

    @Override
    public void setTotalLbaRead(Long totalLbaRead) {
        this.totalLbaRead = totalLbaRead;
    }

    @Override
    public Long getReadErrorRetry() {
        return readErrorRetry;
    }

    @Override
    public void setReadErrorRetry(Long readErrorRetry) {
        this.readErrorRetry = readErrorRetry;
    }

    @Override
    public Long getMinimumSparesRemaining() {
        return minimumSparesRemaining;
    }

    @Override
    public void setMinimumSparesRemaining(Long minimumSparesRemaining) {
        this.minimumSparesRemaining = minimumSparesRemaining;
    }

    @Override
    public Long getNewlyAddedFlashBlock() {
        return newlyAddedFlashBlock;
    }

    @Override
    public void setNewlyAddedFlashBlock(Long newlyAddedFlashBlock) {
        this.newlyAddedFlashBlock = newlyAddedFlashBlock;
    }

    @Override
    public Long getFreeFallProtection() {
        return freeFallProtection;
    }

    @Override
    public void setFreeFallProtection(Long freeFallProtection) {
        this.freeFallProtection = freeFallProtection;
    }

    @Override
    public Long getUnknown255() {
        return unknown255;
    }

    @Override
    public void setUnknown255(Long unknown255) {
        this.unknown255 = unknown255;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnalyticsByModel)) return false;
        AnalyticsByModel that = (AnalyticsByModel) o;
        return totalEvents == that.totalEvents &&
                Objects.equals(model, that.model) &&
                Objects.equals(capacityBytes, that.capacityBytes) &&
                Objects.equals(failure, that.failure) &&
                Objects.equals(rawReadErrorRate, that.rawReadErrorRate) &&
                Objects.equals(throughputPerformance, that.throughputPerformance) &&
                Objects.equals(spinUpTime, that.spinUpTime) &&
                Objects.equals(startStopCount, that.startStopCount) &&
                Objects.equals(reallocatedSectorsCount, that.reallocatedSectorsCount) &&
                Objects.equals(seekErrorRate, that.seekErrorRate) &&
                Objects.equals(seekTimePerformance, that.seekTimePerformance) &&
                Objects.equals(powerOnTimeCount, that.powerOnTimeCount) &&
                Objects.equals(spinUpRetryCount, that.spinUpRetryCount) &&
                Objects.equals(recalibrationRetries, that.recalibrationRetries) &&
                Objects.equals(devicePowerCycleCount, that.devicePowerCycleCount) &&
                Objects.equals(softReadErrorRate, that.softReadErrorRate) &&
                Objects.equals(unknown15, that.unknown15) &&
                Objects.equals(unknown16, that.unknown16) &&
                Objects.equals(unknown17, that.unknown17) &&
                Objects.equals(unknown22, that.unknown22) &&
                Objects.equals(unknown23, that.unknown23) &&
                Objects.equals(unknown24, that.unknown24) &&
                Objects.equals(unknown168, that.unknown168) &&
                Objects.equals(reversedBlockCount, that.reversedBlockCount) &&
                Objects.equals(wearLevellerWorstEraseCount, that.wearLevellerWorstEraseCount) &&
                Objects.equals(unexpectedPowerLoss, that.unexpectedPowerLoss) &&
                Objects.equals(wearLevellingCount, that.wearLevellingCount) &&
                Objects.equals(usedReversedBlockCount, that.usedReversedBlockCount) &&
                Objects.equals(programFailCount, that.programFailCount) &&
                Objects.equals(eraseFailCount, that.eraseFailCount) &&
                Objects.equals(sataDownshifts, that.sataDownshifts) &&
                Objects.equals(endToEndError, that.endToEndError) &&
                Objects.equals(reportedUncErrors, that.reportedUncErrors) &&
                Objects.equals(commandTimeout, that.commandTimeout) &&
                Objects.equals(highFlyWrites, that.highFlyWrites) &&
                Objects.equals(airflowTemperature, that.airflowTemperature) &&
                Objects.equals(gSenseErrorRate, that.gSenseErrorRate) &&
                Objects.equals(powerOffRetractCount, that.powerOffRetractCount) &&
                Objects.equals(loadUnloadCycle, that.loadUnloadCycle) &&
                Objects.equals(hdaTemperature, that.hdaTemperature) &&
                Objects.equals(hardwareEccRecovered, that.hardwareEccRecovered) &&
                Objects.equals(reallocationEventsCount, that.reallocationEventsCount) &&
                Objects.equals(currentPendingSectorCount, that.currentPendingSectorCount) &&
                Objects.equals(uncorrectableSectorCount, that.uncorrectableSectorCount) &&
                Objects.equals(ultraDmaCrcErrorCount, that.ultraDmaCrcErrorCount) &&
                Objects.equals(writeErrorRate, that.writeErrorRate) &&
                Objects.equals(taCounterDetected, that.taCounterDetected) &&
                Objects.equals(unknown218, that.unknown218) &&
                Objects.equals(diskShift, that.diskShift) &&
                Objects.equals(loadedHours, that.loadedHours) &&
                Objects.equals(loadUnloadRetryCount, that.loadUnloadRetryCount) &&
                Objects.equals(loadFriction, that.loadFriction) &&
                Objects.equals(loadUnloadCycleCount, that.loadUnloadCycleCount) &&
                Objects.equals(loadInTime, that.loadInTime) &&
                Objects.equals(lifeLeft, that.lifeLeft) &&
                Objects.equals(enduranceRemaining, that.enduranceRemaining) &&
                Objects.equals(mediaWearoutIndicator, that.mediaWearoutIndicator) &&
                Objects.equals(goodBlockCountAndMaximumEraseCount, that.goodBlockCountAndMaximumEraseCount) &&
                Objects.equals(headFlyingHours, that.headFlyingHours) &&
                Objects.equals(totalLbaWritten, that.totalLbaWritten) &&
                Objects.equals(totalLbaRead, that.totalLbaRead) &&
                Objects.equals(readErrorRetry, that.readErrorRetry) &&
                Objects.equals(minimumSparesRemaining, that.minimumSparesRemaining) &&
                Objects.equals(newlyAddedFlashBlock, that.newlyAddedFlashBlock) &&
                Objects.equals(freeFallProtection, that.freeFallProtection) &&
                Objects.equals(unknown255, that.unknown255);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, totalEvents, capacityBytes, failure, rawReadErrorRate, throughputPerformance, spinUpTime, startStopCount, reallocatedSectorsCount, seekErrorRate, seekTimePerformance, powerOnTimeCount, spinUpRetryCount, recalibrationRetries, devicePowerCycleCount, softReadErrorRate, unknown15, unknown16, unknown17, unknown22, unknown23, unknown24, unknown168, reversedBlockCount, wearLevellerWorstEraseCount, unexpectedPowerLoss, wearLevellingCount, usedReversedBlockCount, programFailCount, eraseFailCount, sataDownshifts, endToEndError, reportedUncErrors, commandTimeout, highFlyWrites, airflowTemperature, gSenseErrorRate, powerOffRetractCount, loadUnloadCycle, hdaTemperature, hardwareEccRecovered, reallocationEventsCount, currentPendingSectorCount, uncorrectableSectorCount, ultraDmaCrcErrorCount, writeErrorRate, taCounterDetected, unknown218, diskShift, loadedHours, loadUnloadRetryCount, loadFriction, loadUnloadCycleCount, loadInTime, lifeLeft, enduranceRemaining, mediaWearoutIndicator, goodBlockCountAndMaximumEraseCount, headFlyingHours, totalLbaWritten, totalLbaRead, readErrorRetry, minimumSparesRemaining, newlyAddedFlashBlock, freeFallProtection, unknown255);
    }

    @Override
    public String toString() {
        return "AnalyticsByModel{" +
                "model='" + model + '\'' +
                ", totalEvents=" + totalEvents +
                ", capacityBytes=" + capacityBytes +
                ", failure=" + failure +
                ", rawReadErrorRate=" + rawReadErrorRate +
                ", throughputPerformance=" + throughputPerformance +
                ", spinUpTime=" + spinUpTime +
                ", startStopCount=" + startStopCount +
                ", reallocatedSectorsCount=" + reallocatedSectorsCount +
                ", seekErrorRate=" + seekErrorRate +
                ", seekTimePerformance=" + seekTimePerformance +
                ", powerOnTimeCount=" + powerOnTimeCount +
                ", spinUpRetryCount=" + spinUpRetryCount +
                ", recalibrationRetries=" + recalibrationRetries +
                ", devicePowerCycleCount=" + devicePowerCycleCount +
                ", softReadErrorRate=" + softReadErrorRate +
                ", unknown15=" + unknown15 +
                ", unknown16=" + unknown16 +
                ", unknown17=" + unknown17 +
                ", unknown22=" + unknown22 +
                ", unknown23=" + unknown23 +
                ", unknown24=" + unknown24 +
                ", unknown168=" + unknown168 +
                ", reversedBlockCount=" + reversedBlockCount +
                ", wearLevellerWorstEraseCount=" + wearLevellerWorstEraseCount +
                ", unexpectedPowerLoss=" + unexpectedPowerLoss +
                ", wearLevellingCount=" + wearLevellingCount +
                ", usedReversedBlockCount=" + usedReversedBlockCount +
                ", programFailCount=" + programFailCount +
                ", eraseFailCount=" + eraseFailCount +
                ", sataDownshifts=" + sataDownshifts +
                ", endToEndError=" + endToEndError +
                ", reportedUncErrors=" + reportedUncErrors +
                ", commandTimeout=" + commandTimeout +
                ", highFlyWrites=" + highFlyWrites +
                ", airflowTemperature=" + airflowTemperature +
                ", gSenseErrorRate=" + gSenseErrorRate +
                ", powerOffRetractCount=" + powerOffRetractCount +
                ", loadUnloadCycle=" + loadUnloadCycle +
                ", hdaTemperature=" + hdaTemperature +
                ", hardwareEccRecovered=" + hardwareEccRecovered +
                ", reallocationEventsCount=" + reallocationEventsCount +
                ", currentPendingSectorCount=" + currentPendingSectorCount +
                ", uncorrectableSectorCount=" + uncorrectableSectorCount +
                ", ultraDmaCrcErrorCount=" + ultraDmaCrcErrorCount +
                ", writeErrorRate=" + writeErrorRate +
                ", taCounterDetected=" + taCounterDetected +
                ", unknown218=" + unknown218 +
                ", diskShift=" + diskShift +
                ", loadedHours=" + loadedHours +
                ", loadUnloadRetryCount=" + loadUnloadRetryCount +
                ", loadFriction=" + loadFriction +
                ", loadUnloadCycleCount=" + loadUnloadCycleCount +
                ", loadInTime=" + loadInTime +
                ", lifeLeft=" + lifeLeft +
                ", enduranceRemaining=" + enduranceRemaining +
                ", mediaWearoutIndicator=" + mediaWearoutIndicator +
                ", goodBlockCountAndMaximumEraseCount=" + goodBlockCountAndMaximumEraseCount +
                ", headFlyingHours=" + headFlyingHours +
                ", totalLbaWritten=" + totalLbaWritten +
                ", totalLbaRead=" + totalLbaRead +
                ", readErrorRetry=" + readErrorRetry +
                ", minimumSparesRemaining=" + minimumSparesRemaining +
                ", newlyAddedFlashBlock=" + newlyAddedFlashBlock +
                ", freeFallProtection=" + freeFallProtection +
                ", unknown255=" + unknown255 +
                '}';
    }
}
