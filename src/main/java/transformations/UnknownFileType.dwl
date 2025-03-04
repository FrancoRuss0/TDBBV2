%dw 2.0
output application/java
---
(data) -> data map (record,index) ->
{
	AllFields : (record pluck $)
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.UnknownFileType"}
