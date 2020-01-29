package gratigny.guillaume.deezeralbum.extension

import java.text.SimpleDateFormat

fun String.dateFormat(str: String = this): String {
    val formatIn = SimpleDateFormat("yyyy-MM-dd")
    val formatOut = SimpleDateFormat("dd MMMM yyyy")

    return formatOut.format(formatIn.parse(str))
}