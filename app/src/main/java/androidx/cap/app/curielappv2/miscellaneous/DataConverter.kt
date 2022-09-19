package androidx.cap.app.curielappv2.miscellaneous

import java.time.LocalDate
import java.time.LocalDate.*
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

object DataConverter {
    @Throws(DateTimeParseException::class)
    fun stringToDate(data: String): LocalDate?  {
        // gg/mm/aaa
        val formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALY)
        val date= parse(data,formatter)
        if(date.isAfter(now()))
            throw DateTimeParseException("Data nel futuro","Data nel futuro",-1)

        return date
    }
}