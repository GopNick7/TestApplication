package com.chisw.testapplication.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Nikita R. on 22.12.2018.
 */
fun String.parseISO8601Time(): Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US).parse(this)
