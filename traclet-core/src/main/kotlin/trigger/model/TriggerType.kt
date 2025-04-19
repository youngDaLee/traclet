package traclet.core.trigger.model

/**
 * 트리거 타입
 */
enum class TriggerType {
    REALTIME,   // 이벤트 발생 시점에 즉시 알림
    STORED,     // 저장된 모든 이벤트 기준으로 알림
}