package traclet.core

import traclet.core.collector.Store
import traclet.core.collector.model.EventMetric
import traclet.core.trigger.model.TriggerRule

object Traclet {
    private var _store: Store? = null
    val store: Store
        get() = _store ?: error("Traclet is not initialized. Call Traclet.init(...) first.")

    private val rules = mutableListOf<TriggerRule>()
    private var initialized = false

    fun init(
        store: Store = Store.default(),
        triggerRules: List<TriggerRule> = emptyList()
    ) {
        if (initialized) error("Traclet can only be initialized once.")

        _store = store
        rules.addAll(triggerRules)
        initialized = true
    }

    fun record(
        key: String,
        duration: Long? = null,
        tags: Map<String, String> = emptyMap()
    ) {
        val metric = EventMetric(
            key = key,
            duration = duration,
            tags = tags
        )

        // 저장소 저장
        store.save(metric)

        // 알림 조건 확인
        rules.forEach { rule ->
            if (rule.trigger.isTrigger(metric, store.getEvents()[metric.key] ?: emptyList())) {
                rule.alerter.report(metric.key)
            }
        }
    }
}