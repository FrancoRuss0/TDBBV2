package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;

@Component
public class XmlGenerator {

    public String generateXml(List<TDB_Maintenance> report) {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<table>");
        xmlBuilder.append("<tr>");
        xmlBuilder.append("<th>File name</th>");
        xmlBuilder.append("<th>Num records</th>");
        xmlBuilder.append("<th>Success</th>");
        xmlBuilder.append("<th>Enc file name</th>");
        xmlBuilder.append("<th>Date started</th>");
        xmlBuilder.append("<th>Date ended</th>");
        xmlBuilder.append("</tr>");

        for (TDB_Maintenance maintenance : report) {
            xmlBuilder.append("<tr>");
            xmlBuilder.append("<td>").append(maintenance.getFileName()).append("</td>");
            xmlBuilder.append("<td>").append(maintenance.getNumRecords()).append("</td>");
            String successColor = maintenance.getSuccess() ? "green" : "red";
            xmlBuilder.append("<td bgcolor=\"").append(successColor).append("\">").append(maintenance.getSuccess()).append("</td>");
            xmlBuilder.append("<td>").append(maintenance.getEncFileName()).append("</td>");
            xmlBuilder.append("<td>").append(maintenance.getDateStarted()).append("</td>");
            xmlBuilder.append("<td>").append(maintenance.getDateEnded()).append("</td>");
            xmlBuilder.append("</tr>");
        }

        xmlBuilder.append("</table>");
        return xmlBuilder.toString();
    }
}
