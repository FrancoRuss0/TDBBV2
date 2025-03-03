%dw 2.0
output application/java
---
(data) -> data map (record,index) ->
{
	AllFields : (record pluck $)
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.UnknownFileType"}
