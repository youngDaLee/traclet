package traclet.core.collector.model

/**
 * RetentionPolicy는 수집된 데이터를 저장하는 정책을 정의
 */
class RetentionPolicy (
    val ttlMillis: Long   // Time to Live (Milliseconds)
){
    companion object {
        fun ofMinutes(min: Long) = RetentionPolicy(min * 60 * 1000)
        fun ofHours(hour: Long) = RetentionPolicy(hour * 60 * 60 * 1000)
        fun ofSeconds(sec: Long) = RetentionPolicy(sec * 1000)
    }
}