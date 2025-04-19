package examples

import traclet.core.Traclet
import traclet.core.alert.ConsoleAlerter
import traclet.core.trigger.model.TriggerRule
import traclet.core.trigger.ThresholdTrigger

fun main() {
    default()
}

fun default() {
    println("🟢 Traclet 예제 시작 : default")

    // 1. 트리거 조건 설정 (동일 키 이벤트가 3번 발생 시 알림)
    val rule = TriggerRule(
        trigger = ThresholdTrigger(threshold = 3),
        alerter = ConsoleAlerter()
    )
    // 2. Traclet 초기화
    Traclet.init(
        triggerRules = listOf(rule)
    )

    // 4. 이벤트 수집 (3번째 호출 시 알림 발생)
    repeat(3) {
        Traclet.record("test.key")
    }

    println("✅ Traclet 예제 종료 : default")
}
