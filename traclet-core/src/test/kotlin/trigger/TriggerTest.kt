package trigger

import traclet.core.collector.model.EventMetric
import traclet.core.trigger.RealTimeTrigger
import traclet.core.trigger.ThresholdTrigger
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TriggerTest {

    @Test
    fun `ThresholdTrigger는 저장된 이벤트 수가 기준 이상일 때 작동해야 한다`() {
        val trigger = ThresholdTrigger(threshold = 3)

        val stored = listOf(
            EventMetric(key = "event.test"),
            EventMetric(key = "event.test"),
            EventMetric(key = "event.test")
        )

        val result = trigger.isTrigger(
            event = EventMetric(key = "event.test"),
            storedEvents = stored
        )

        assertTrue(result)
    }

    @Test
    fun `ThresholdTrigger는 저장된 이벤트 수가 기준보다 적을 때 작동하지 않아야 한다`() {
        val trigger = ThresholdTrigger(threshold = 5)

        val stored = listOf(
            EventMetric(key = "event.test"),
            EventMetric(key = "event.test")
        )

        val result = trigger.isTrigger(
            event = EventMetric(key = "event.test"),
            storedEvents = stored
        )

        assertFalse(result)
    }

    @Test
    fun `RealtimeTrigger는 이벤트가 호출되면 true를 반환해야 한다`() {
        val trigger = RealTimeTrigger()

        val result = trigger.isTrigger(
            event = EventMetric(key = "event.realtime"),
            storedEvents = emptyList()
        )

        assertTrue(result)
    }
}