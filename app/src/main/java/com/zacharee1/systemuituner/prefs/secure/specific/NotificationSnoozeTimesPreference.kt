package com.zacharee1.systemuituner.prefs.secure.specific

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import com.zacharee1.systemuituner.R
import com.zacharee1.systemuituner.interfaces.ISpecificPreference
import com.zacharee1.systemuituner.prefs.secure.base.BaseSecurePreference
import com.zacharee1.systemuituner.util.SettingsType
import com.zacharee1.systemuituner.util.prefManager
import com.zacharee1.systemuituner.util.verifiers.ShowForTouchWiz
import com.zacharee1.systemuituner.util.writeGlobal

class NotificationSnoozeTimesPreference(context: Context, attrs: AttributeSet) : BaseSecurePreference(context, attrs), ISpecificPreference {
    override val keys: Array<String>
        get() = arrayOf(key)
    override var type = SettingsType.GLOBAL

    init {
        key = "notification_snooze_options"
        setTitle(R.string.option_custom_notification_snooze_times)
        setSummary(R.string.option_custom_notification_snooze_times_desc)

        dialogTitle = title
        dialogMessage = summary
        iconColor = context.resources.getColor(R.color.pref_color_5, context.theme)
        setIcon(R.drawable.ic_baseline_snooze_24)

        lowApi = Build.VERSION_CODES.O_MR1
    }

    override fun onValueChanged(newValue: Any?, key: String) {
        context.prefManager.saveOption(SettingsType.GLOBAL, "notification_snooze_options", newValue)
        context.writeGlobal("notification_snooze_options", newValue)
    }
}