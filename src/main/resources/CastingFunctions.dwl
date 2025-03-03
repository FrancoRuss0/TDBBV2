%dw 2.0
fun toString(str) = if (str == "" or str == null) null  else (trim (str) as String)
fun toNumber(str)= if(str == "" or str == null) null else (trim (str) as Number)
fun toDate(str,format)= if(str == "" or str == null) null else (trim (str) as Date {format: format})
fun toLocalTime(str,format)= if(str == "" or str == null) null else (trim (str) as LocalTime {format: format})
fun toLocalDateTime(str,format)= if(str == "" or str == null) null else (trim (str) as LocalDateTime {format: format})
---
{
	toString : (str) -> toString(str),
	toNumber : (str) -> toNumber(str),
	toDate : (str,format) -> toDate(str,format),
	toLocalTime : (str,format) -> toLocalTime(str,format),
	toLocalDateTime : (str,format) -> toLocalDateTime(str,format)
} 