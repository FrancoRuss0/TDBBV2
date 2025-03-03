%dw 2.0
output application/java 
---
using (transform = readUrl("classpath://transformations/" ++ filename ++ ".dwl", "application/dw", {privileges: "Resource"}))	   
transform(read(payload, "application/csv", { separator: "|", header: false}))