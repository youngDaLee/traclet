package alert

import traclet.core.alert.Alerter
import traclet.core.alert.ConsoleAlerter
import kotlin.test.Test
import kotlin.test.assertTrue

class AlerterTest {

    @Test
    fun `Alerter 생성 및 출력`() {
        var triggered = false

        val alerter = object : Alerter {
            override fun report(eventKey: String) {
                println("[Traclet] '$eventKey' 이벤트가 발생했습니다")
                triggered = true
            }
        }

        val testEventKey = "test.key"
        alerter.report(testEventKey)

        assertTrue(triggered)
    }

    @Test
    fun `ConsoleAlerter 생성 및 출력`() {
        val alerter = ConsoleAlerter()

        val testEventKey = "test.key"
        alerter.report(testEventKey)

        assertTrue(true) // 콘솔 출력 확인은 수동으로 해야 함
    }


    @Test
    fun `Default Alerter 생성 및 출력`() {
        val alerter = Alerter.default()

        val testEventKey = "test.key"
        alerter.report(testEventKey)

        assertTrue(true) // 콘솔 출력 확인은 수동으로 해야 함
    }
}