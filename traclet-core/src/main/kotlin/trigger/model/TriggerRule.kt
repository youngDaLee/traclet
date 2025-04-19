package traclet.core.trigger.model

import traclet.core.alert.Alerter
import traclet.core.trigger.Trigger

data class TriggerRule (
    val trigger: Trigger,
    val alerter: Alerter = Alerter.default(),
)