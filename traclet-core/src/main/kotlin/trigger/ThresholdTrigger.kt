package traclet.core.trigger

import traclet.core.collector.model.EventMetric
import traclet.core.trigger.model.TriggerType

/**
 * 지정된 개수를 기준으로 트리거 발동
 */
class ThresholdTrigger (
    override val type: TriggerType,
    private val threshold: Int,
) : Trigger {
    override fun isTrigger(event: EventMetric, storedEvents: List<EventMetric>): Boolean {
        return when (type) {
            TriggerType.REALTIME -> true
            TriggerType.STORED -> storedEvents.size >= threshold
        }
    }
}