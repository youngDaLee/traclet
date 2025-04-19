package examples

import traclet.core.Traclet
import traclet.core.alert.Alerter
import traclet.core.trigger.model.TriggerRule
import traclet.core.trigger.ThresholdTrigger

fun main() {
    println("🟢 Traclet 예제 시작")

    // 1. 알림 핸들러 정의
    val consoleAlerter = object : Alerter {
        override fun report(eventKey: String) {
            println("🚨 '$eventKey' 이벤트가 트리거 조건을 만족했습니다!")
        }
    }

    // 2. 트리거 조건 설정 (동일 키 이벤트가 3번 발생 시 알림)
    val trigger = ThresholdTrigger(threshold = 3)
    val rule = TriggerRule(trigger, consoleAlerter)

    // 3. Traclet 초기화
    Traclet.init(
        triggerRules = listOf(rule)
    )

    // 4. 이벤트 수집 (3번째 호출 시 알림 발생)
    repeat(3) {
        Traclet.record("login.failed")
    }

    println("✅ Traclet 예제 종료")
}
