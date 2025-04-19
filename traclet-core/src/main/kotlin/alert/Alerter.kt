package traclet.core.alert

/**
 * 알림 전송 수단 인터페이스
 */
interface Alerter {
    fun report(eventKey : String)
}