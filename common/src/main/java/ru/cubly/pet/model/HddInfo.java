package ru.cubly.pet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface HddInfo {
    String getModel();

    void setModel(String model);

    Long getCapacityBytes();

    void setCapacityBytes(Long capacityBytes);

    Long getFailure();

    void setFailure(Long failure);

    Long getRawReadErrorRate();

    void setRawReadErrorRate(Long rawReadErrorRate);

    Long getThroughputPerformance();

    void setThroughputPerformance(Long throughputPerformance);

    Long getSpinUpTime();

    void setSpinUpTime(Long spinUpTime);

    Long getStartStopCount();

    void setStartStopCount(Long startStopCount);

    Long getReallocatedSectorsCount();

    void setReallocatedSectorsCount(Long reallocatedSectorsCount);

    Long getSeekErrorRate();

    void setSeekErrorRate(Long seekErrorRate);

    Long getSeekTimePerformance();

    void setSeekTimePerformance(Long seekTimePerformance);

    Long getPowerOnTimeCount();

    void setPowerOnTimeCount(Long powerOnTimeCount);

    Long getSpinUpRetryCount();

    void setSpinUpRetryCount(Long spinUpRetryCount);

    Long getRecalibrationRetries();

    void setRecalibrationRetries(Long recalibrationRetries);

    Long getDevicePowerCycleCount();

    void setDevicePowerCycleCount(Long devicePowerCycleCount);

    Long getSoftReadErrorRate();

    void setSoftReadErrorRate(Long softReadErrorRate);

    Long getUnknown15();

    void setUnknown15(Long unknown15);

    Long getUnknown16();

    void setUnknown16(Long unknown16);

    Long getUnknown17();

    void setUnknown17(Long unknown17);

    Long getUnknown22();

    void setUnknown22(Long unknown22);

    Long getUnknown23();

    void setUnknown23(Long unknown23);

    Long getUnknown24();

    void setUnknown24(Long unknown24);

    Long getUnknown168();

    void setUnknown168(Long unknown168);

    Long getReversedBlockCount();

    void setReversedBlockCount(Long reversedBlockCount);

    Long getWearLevellerWorstEraseCount();

    void setWearLevellerWorstEraseCount(Long wearLevellerWorstEraseCount);

    Long getUnexpectedPowerLoss();

    void setUnexpectedPowerLoss(Long unexpectedPowerLoss);

    Long getWearLevellingCount();

    void setWearLevellingCount(Long wearLevellingCount);

    Long getUsedReversedBlockCount();

    void setUsedReversedBlockCount(Long usedReversedBlockCount);

    Long getProgramFailCount();

    void setProgramFailCount(Long programFailCount);

    Long getEraseFailCount();

    void setEraseFailCount(Long eraseFailCount);

    Long getSataDownshifts();

    void setSataDownshifts(Long sataDownshifts);

    Long getEndToEndError();

    void setEndToEndError(Long endToEndError);

    Long getReportedUncErrors();

    void setReportedUncErrors(Long reportedUncErrors);

    Long getCommandTimeout();

    void setCommandTimeout(Long commandTimeout);

    Long getHighFlyWrites();

    void setHighFlyWrites(Long highFlyWrites);

    Long getAirflowTemperature();

    void setAirflowTemperature(Long airflowTemperature);

    Long getGSenseErrorRate();

    void setGSenseErrorRate(Long gSenseErrorRate);

    Long getPowerOffRetractCount();

    void setPowerOffRetractCount(Long powerOffRetractCount);

    Long getLoadUnloadCycle();

    void setLoadUnloadCycle(Long loadUnloadCycle);

    Long getHdaTemperature();

    void setHdaTemperature(Long hdaTemperature);

    Long getHardwareEccRecovered();

    void setHardwareEccRecovered(Long hardwareEccRecovered);

    Long getReallocationEventsCount();

    void setReallocationEventsCount(Long reallocationEventsCount);

    Long getCurrentPendingSectorCount();

    void setCurrentPendingSectorCount(Long currentPendingSectorCount);

    Long getUncorrectableSectorCount();

    void setUncorrectableSectorCount(Long uncorrectableSectorCount);

    Long getUltraDmaCrcErrorCount();

    void setUltraDmaCrcErrorCount(Long ultraDmaCrcErrorCount);

    Long getWriteErrorRate();

    void setWriteErrorRate(Long writeErrorRate);

    Long getTaCounterDetected();

    void setTaCounterDetected(Long taCounterDetected);

    Long getUnknown218();

    void setUnknown218(Long unknown218);

    Long getDiskShift();

    void setDiskShift(Long diskShift);

    Long getLoadedHours();

    void setLoadedHours(Long loadedHours);

    Long getLoadUnloadRetryCount();

    void setLoadUnloadRetryCount(Long loadUnloadRetryCount);

    Long getLoadFriction();

    void setLoadFriction(Long loadFriction);

    Long getLoadUnloadCycleCount();

    void setLoadUnloadCycleCount(Long loadUnloadCycleCount);

    Long getLoadInTime();

    void setLoadInTime(Long loadInTime);

    Long getLifeLeft();

    void setLifeLeft(Long lifeLeft);

    Long getEnduranceRemaining();

    void setEnduranceRemaining(Long enduranceRemaining);

    Long getMediaWearoutIndicator();

    void setMediaWearoutIndicator(Long mediaWearoutIndicator);

    Long getGoodBlockCountAndMaximumEraseCount();

    void setGoodBlockCountAndMaximumEraseCount(Long goodBlockCountAndMaximumEraseCount);

    Long getHeadFlyingHours();

    void setHeadFlyingHours(Long headFlyingHours);

    Long getTotalLbaWritten();

    void setTotalLbaWritten(Long totalLbaWritten);

    Long getTotalLbaRead();

    void setTotalLbaRead(Long totalLbaRead);

    Long getReadErrorRetry();

    void setReadErrorRetry(Long readErrorRetry);

    Long getMinimumSparesRemaining();

    void setMinimumSparesRemaining(Long minimumSparesRemaining);

    Long getNewlyAddedFlashBlock();

    void setNewlyAddedFlashBlock(Long newlyAddedFlashBlock);

    Long getFreeFallProtection();

    void setFreeFallProtection(Long freeFallProtection);

    Long getUnknown255();

    void setUnknown255(Long unknown255);
}
