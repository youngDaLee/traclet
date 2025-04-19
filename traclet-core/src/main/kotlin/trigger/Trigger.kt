package traclet.core.trigger

import traclet.core.collector.model.EventMetric

/**
 * 트리거(이벤트) 인터페이스
 */
interface Trigger {
    fun isTrigger(event: EventMetric, storedEvents: List<EventMetric> = emptyList()): Boolean
}