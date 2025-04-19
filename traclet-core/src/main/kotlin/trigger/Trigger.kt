package traclet.core.trigger

import traclet.core.collector.model.EventMetric
import traclet.core.trigger.model.TriggerType

/**
 * 트리거(이벤트) 인터페이스
 */
interface Trigger {
    val type: TriggerType   // 트리거 타입(실시간, 저장된 이벤트 기준)
    fun isTrigger(event: EventMetric, storedEvents: List<EventMetric> = emptyList()): Boolean
}