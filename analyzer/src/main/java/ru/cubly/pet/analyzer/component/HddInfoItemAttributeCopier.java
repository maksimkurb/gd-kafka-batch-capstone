package ru.cubly.pet.analyzer.component;

import org.springframework.stereotype.Component;
import ru.cubly.pet.model.HddInfo;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class HddInfoItemAttributeCopier {
    @FunctionalInterface
    public interface HddInfoPropertyConsumer {
        void consume(Supplier<Long> sourceSupplier, Supplier<Long> targetSupplier, Consumer<Long> targetConsumer);
    }

    public void copyAttributes(HddInfo source, HddInfo target, HddInfoPropertyConsumer consumer) {
        consumer.consume(source::getCapacityBytes, target::getCapacityBytes, target::setCapacityBytes);
        consumer.consume(source::getFailure, target::getFailure, target::setFailure);
        consumer.consume(source::getRawReadErrorRate, target::getRawReadErrorRate, target::setRawReadErrorRate);
        consumer.consume(source::getThroughputPerformance, target::getThroughputPerformance, target::setThroughputPerformance);
        consumer.consume(source::getSpinUpTime, target::getSpinUpTime, target::setSpinUpTime);
        consumer.consume(source::getStartStopCount, target::getStartStopCount, target::setStartStopCount);
        consumer.consume(source::getReallocatedSectorsCount, target::getReallocatedSectorsCount, target::setReallocatedSectorsCount);
        consumer.consume(source::getSeekErrorRate, target::getSeekErrorRate, target::setSeekErrorRate);
        consumer.consume(source::getSeekTimePerformance, target::getSeekTimePerformance, target::setSeekTimePerformance);
        consumer.consume(source::getPowerOnTimeCount, target::getPowerOnTimeCount, target::setPowerOnTimeCount);
        consumer.consume(source::getSpinUpRetryCount, target::getSpinUpRetryCount, target::setSpinUpRetryCount);
        consumer.consume(source::getRecalibrationRetries, target::getRecalibrationRetries, target::setRecalibrationRetries);
        consumer.consume(source::getDevicePowerCycleCount, target::getDevicePowerCycleCount, target::setDevicePowerCycleCount);
        consumer.consume(source::getSoftReadErrorRate, target::getSoftReadErrorRate, target::setSoftReadErrorRate);
        consumer.consume(source::getUnknown15, target::getUnknown15, target::setUnknown15);
        consumer.consume(source::getUnknown16, target::getUnknown16, target::setUnknown16);
        consumer.consume(source::getUnknown17, target::getUnknown17, target::setUnknown17);
        consumer.consume(source::getUnknown22, target::getUnknown22, target::setUnknown22);
        consumer.consume(source::getUnknown23, target::getUnknown23, target::setUnknown23);
        consumer.consume(source::getUnknown24, target::getUnknown24, target::setUnknown24);
        consumer.consume(source::getUnknown168, target::getUnknown168, target::setUnknown168);
        consumer.consume(source::getReversedBlockCount, target::getReversedBlockCount, target::setReversedBlockCount);
        consumer.consume(source::getWearLevellerWorstEraseCount, target::getWearLevellerWorstEraseCount, target::setWearLevellerWorstEraseCount);
        consumer.consume(source::getUnexpectedPowerLoss, target::getUnexpectedPowerLoss, target::setUnexpectedPowerLoss);
        consumer.consume(source::getWearLevellingCount, target::getWearLevellingCount, target::setWearLevellingCount);
        consumer.consume(source::getUsedReversedBlockCount, target::getUsedReversedBlockCount, target::setUsedReversedBlockCount);
        consumer.consume(source::getProgramFailCount, target::getProgramFailCount, target::setProgramFailCount);
        consumer.consume(source::getEraseFailCount, target::getEraseFailCount, target::setEraseFailCount);
        consumer.consume(source::getSataDownshifts, target::getSataDownshifts, target::setSataDownshifts);
        consumer.consume(source::getEndToEndError, target::getEndToEndError, target::setEndToEndError);
        consumer.consume(source::getReportedUncErrors, target::getReportedUncErrors, target::setReportedUncErrors);
        consumer.consume(source::getCommandTimeout, target::getCommandTimeout, target::setCommandTimeout);
        consumer.consume(source::getHighFlyWrites, target::getHighFlyWrites, target::setHighFlyWrites);
        consumer.consume(source::getAirflowTemperature, target::getAirflowTemperature, target::setAirflowTemperature);
        consumer.consume(source::getGSenseErrorRate, target::getGSenseErrorRate, target::setGSenseErrorRate);
        consumer.consume(source::getPowerOffRetractCount, target::getPowerOffRetractCount, target::setPowerOffRetractCount);
        consumer.consume(source::getLoadUnloadCycle, target::getLoadUnloadCycle, target::setLoadUnloadCycle);
        consumer.consume(source::getHdaTemperature, target::getHdaTemperature, target::setHdaTemperature);
        consumer.consume(source::getHardwareEccRecovered, target::getHardwareEccRecovered, target::setHardwareEccRecovered);
        consumer.consume(source::getReallocationEventsCount, target::getReallocationEventsCount, target::setReallocationEventsCount);
        consumer.consume(source::getCurrentPendingSectorCount, target::getCurrentPendingSectorCount, target::setCurrentPendingSectorCount);
        consumer.consume(source::getUncorrectableSectorCount, target::getUncorrectableSectorCount, target::setUncorrectableSectorCount);
        consumer.consume(source::getUltraDmaCrcErrorCount, target::getUltraDmaCrcErrorCount, target::setUltraDmaCrcErrorCount);
        consumer.consume(source::getWriteErrorRate, target::getWriteErrorRate, target::setWriteErrorRate);
        consumer.consume(source::getTaCounterDetected, target::getTaCounterDetected, target::setTaCounterDetected);
        consumer.consume(source::getUnknown218, target::getUnknown218, target::setUnknown218);
        consumer.consume(source::getDiskShift, target::getDiskShift, target::setDiskShift);
        consumer.consume(source::getLoadedHours, target::getLoadedHours, target::setLoadedHours);
        consumer.consume(source::getLoadUnloadRetryCount, target::getLoadUnloadRetryCount, target::setLoadUnloadRetryCount);
        consumer.consume(source::getLoadFriction, target::getLoadFriction, target::setLoadFriction);
        consumer.consume(source::getLoadUnloadCycleCount, target::getLoadUnloadCycleCount, target::setLoadUnloadCycleCount);
        consumer.consume(source::getLoadInTime, target::getLoadInTime, target::setLoadInTime);
        consumer.consume(source::getLifeLeft, target::getLifeLeft, target::setLifeLeft);
        consumer.consume(source::getEnduranceRemaining, target::getEnduranceRemaining, target::setEnduranceRemaining);
        consumer.consume(source::getMediaWearoutIndicator, target::getMediaWearoutIndicator, target::setMediaWearoutIndicator);
        consumer.consume(source::getGoodBlockCountAndMaximumEraseCount, target::getGoodBlockCountAndMaximumEraseCount, target::setGoodBlockCountAndMaximumEraseCount);
        consumer.consume(source::getHeadFlyingHours, target::getHeadFlyingHours, target::setHeadFlyingHours);
        consumer.consume(source::getTotalLbaWritten, target::getTotalLbaWritten, target::setTotalLbaWritten);
        consumer.consume(source::getTotalLbaRead, target::getTotalLbaRead, target::setTotalLbaRead);
        consumer.consume(source::getReadErrorRetry, target::getReadErrorRetry, target::setReadErrorRetry);
        consumer.consume(source::getMinimumSparesRemaining, target::getMinimumSparesRemaining, target::setMinimumSparesRemaining);
        consumer.consume(source::getNewlyAddedFlashBlock, target::getNewlyAddedFlashBlock, target::setNewlyAddedFlashBlock);
        consumer.consume(source::getFreeFallProtection, target::getFreeFallProtection, target::setFreeFallProtection);
        consumer.consume(source::getUnknown255, target::getUnknown255, target::setUnknown255);
    }

}
