import traclet.core.Traclet
import traclet.core.alert.Alerter
import traclet.core.trigger.ThresholdTrigger
import traclet.core.trigger.model.TriggerRule
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TracletTest {

    @Test
    fun `Traclet은 이벤트를 수집하고 알림을 발생시킨다`() {
        val triggered = AtomicBoolean(false)

        val alerter = object : Alerter {
            override fun report(eventKey: String) {
                triggered.set(true)
            }
        }

        val trigger = ThresholdTrigger(threshold = 2)
        val rule = TriggerRule(trigger, alerter)

        Traclet.init(
            triggerRules = listOf(rule)
        )

        Traclet.record("event.test")
        assertEquals(false, triggered.get())

        Traclet.record("event.test")
        assertTrue(triggered.get())
    }
}