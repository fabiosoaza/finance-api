package com.github.fabiosoaza.core.domain

import java.time.ZonedDateTime

data class Quote(val ticker:String, val exchange:String, val date: ZonedDateTime, val lastPrice: Price) {
}