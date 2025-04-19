package traclet.core.collector

import traclet.core.collector.model.EventMetric
import traclet.core.collector.model.RetentionPolicy
import java.util.concurrent.ConcurrentHashMap

class InMemoryStore (
    override val retentionPolicy : RetentionPolicy = RetentionPolicy.ofMinutes(1) // 기본 보존 정책은 1분
) : Store {
    private val events: MutableMap<String, MutableList<EventMetric>> = ConcurrentHashMap()

    /**
     * 수집되는 이벤트를 저장하는 메서드
     *
     * @param event 수집되는 이벤트
     */
    override fun internalSave(event: EventMetric) {
        events.computeIfAbsent(event.key) { mutableListOf() }.add(event)
    }

    /**
     * 수집된 이벤트를 반환하는 메서드
     *
     * @return 수집된 이벤트
     */
    override fun getEvents(): Map<String, List<EventMetric>> {
        return events.toMap()
    }

    /**
     * 저장 주기에 따라 이벤트를 삭제하는 메서드
     */
    override fun cleanup() {
        val cutoff = System.currentTimeMillis() - retentionPolicy.ttlMillis
        events.values.forEach { list ->
            list.removeIf { it.timestamp < cutoff }
        }
    }
}