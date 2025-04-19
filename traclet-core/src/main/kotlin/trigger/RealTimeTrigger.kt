package traclet.core.trigger

import traclet.core.collector.model.EventMetric

/**
 * 실시간 트리거
 * 모든 이벤트에 대해 이벤트가 발생하면 트리거 발동
 */
class RealTimeTrigger : Trigger {
    override fun isTrigger(event: EventMetric, storedEvents: List<EventMetric>): Boolean {
        return true
    }
}