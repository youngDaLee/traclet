package traclet.core.trigger

import traclet.core.collector.model.EventMetric

/**
 * 지정된 개수를 기준으로 트리거 발동
 */
class ThresholdTrigger (
    private val threshold: Int,
) : Trigger {
    override fun isTrigger(event: EventMetric, storedEvents: List<EventMetric>): Boolean {
        return storedEvents.size >= threshold
    }
}