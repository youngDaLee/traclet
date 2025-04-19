package traclet.core.alert

/**
 * 콘솔 출력
 */
class ConsoleAlerter : Alerter {
    override fun report(eventKey: String) {
        println("[Traclet] '$eventKey' 이벤트가 발생했습니다")
    }
}