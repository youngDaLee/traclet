package collector

import traclet.core.collector.Store
import traclet.core.collector.model.EventMetric
import traclet.core.collector.model.RetentionPolicy
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class StoreTest {

    @Test
    fun `이벤트 수집`() {
        val store = Store.default()

        val metric = EventMetric(key = "event.test")

        store.save(metric)
        store.save(metric)

        assertEquals(2, store.getEvents()["event.test"]?.size)
    }

    @Test
    fun `1초 후 이벤트 자동 삭제 확인`() {
        val store = Store.default(RetentionPolicy.ofSeconds(1))

        val metric = EventMetric(key = "event.test")

        store.save(metric)
        assertEquals(1, store.getEvents()["event.ttl"]?.size)

        Thread.sleep(1_500) // 1.5초 대기

        store.save(metric)

        val events = store.getEvents()["event.ttl"]
        assertNotNull(events)
        assertEquals(1, events.size) // old one should be cleaned up
    }
}