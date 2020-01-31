package gratigny.guillaume.deezeralbum.extension

import java.text.SimpleDateFormat

/**
 * String extension for date conversion from 1900-01-01 to 01 January 1900
 *
 * @param str the string to transform, if no str provided, use this
 * @return the string with the date converted
 */
fun String.dateFormat(str: String = this): String {
    val formatIn = SimpleDateFormat("yyyy-MM-dd")
    val formatOut = SimpleDateFormat("dd MMMM yyyy")

    return formatOut.format(formatIn.parse(str))
}