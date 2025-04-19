package traclet.core.collector.model

/**
 * 수집되는 이벤트 단위
 */
data class EventMetric(
    val key: String,                                   // 이벤트 이름
    val timestamp: Long = System.currentTimeMillis(),  // 기록 시각
    val duration: Long? = null,                        // RPC 등의 duration(ms) 기록
    val tags: Map<String, String> = emptyMap()         // 부가 정보 (e.g. userId, route, method, 점수, 속도 등)
) {
    override fun toString(): String {
        return "EventMetric(key='$key', duration=$duration, tags=$tags)"
    }
}