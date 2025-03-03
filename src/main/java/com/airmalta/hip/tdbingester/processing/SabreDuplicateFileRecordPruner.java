package com.airmalta.hip.tdbingester.processing;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.airmalta.hip.tdbingester.filepojos.PNRRecord;
import com.airmalta.hip.tdbingester.filepojos.VCRRecord;

/**
 * Sabre's PNR and VCR files may occasionally contain duplicate records.
 * This means that two or more records in the same file contain the exact same values for all the fields which should uniquely identify each record.
 * Take ResRemarks as an example. Each ResRemark record should be uniquely identified by these 4 fields: PNRLocatorID, PNRCreateDate, ResRemarkSeqId, IntraPNRSetNbr.
 * But, it is possible to receive the following two ResRemarks records in the same file: 
 *
 * 05|PWMKDF|2017-09-27|2017-11-29 04:35:29.000961|7|SPLIT TO/070822/03NOV17 TIUHMS 30/30 29/29 C/29GRPS GREEN|8||||0
 * 05|PWMKDF|2017-09-27|2020-10-07 06:00:00.000000|7|SPLIT TO/070822/03NOV17 TIUHMS 30/30 29/29 C/29GRPS GREEN|8||||0
 * 
 * In this example, the values of the 4 fields that should uniquely identify a ResRemark in a file are the same:
 *   - PNRLocatorId: PWMKDF
 *   - PNRCreateDate: 2017-09-27
 *   - ResRemarkSeqId: 7
 *   - IntraPNRSetNbr: 0
 * 
 * Trying to insert these two records in the ResRemarks table would result in a "Duplicate Key" database error due to the table's unique constraint.
 *  
 * This class contains two static methods whose job is to remove such duplicate records in PNR and VCR files.
 * Only the record with the latest TransactionDateTime (in case of VCR files) or the latest FromDateTime (in case of PNR files) is kept from the set of duplicates.
 * 
 * These methods work as follows:
 * 
 *   1. Initialize an empty Set of type VCRRecord/PNRRecord called uniqueRecords
 *   
 *   2. Order, in descending order, PNR/VCR records based on PNRLocatorId, PNRCreateDate and FromDateTime (for PNR records)
 *      and PrimaryDocNbr, VCRCreateDate and TransactionDateTime (for VCR records). 
 *      Therefore, in case of duplicate entries, the entry with the latest FromDateTime/TransactionDateTime will occur first in the list.
 *      
 *   3. For each record, check if it is contained in the uniqueRecords Set. 
 *      A record would already be contained in this set if it is equal (based on the equals() and hashCode() methods on the unique fields) to an existing record in the set.
 *      
 *   4. Return the uniqueRecords set. 
 * 
 * @author James Scicluna
 *
 */
public class SabreDuplicateFileRecordPruner {
    
    private static final int DESCENDING = -1;
    
    /*
     * Removes duplicate VCR records based on the equals() method defined in each VCR file class.
     * Amongst the duplicate records, the one with the latest TransactionDateTime is kept.
     */
    public static Set<? extends VCRRecord> removeDuplicateVCRRecords(List<VCRRecord> vcrRecords) {
    	
        final Set<VCRRecord> uniqueRecords = new HashSet<>();
        
        vcrRecords.stream()
            .sorted(new Comparator<VCRRecord>() {
                @Override
                public int compare(VCRRecord lhs, VCRRecord rhs) {
                    // most up to date is top of the list
                    // this is important because it is the first element that is
                    // added to the 'uniques' set
                    if (lhs.getPrimaryDocNbr().compareTo(rhs.getPrimaryDocNbr()) == 0) {
                        if (lhs.getVCRCreateDate().compareTo(rhs.getVCRCreateDate()) == 0) {
                            return DESCENDING * (lhs.getTransactionDateTime().compareTo(rhs.getTransactionDateTime()));
                        }
                        else return DESCENDING * (lhs.getVCRCreateDate().compareTo(rhs.getVCRCreateDate()));
                    }
                    else return DESCENDING * (lhs.getPrimaryDocNbr().compareTo(rhs.getPrimaryDocNbr()));
                }
            })
            .forEachOrdered(record -> {
                // Attempt to add the record to the set of unique records,
                // as defined by its equals() and hashcode() implementation.
                // If the record cannot be added, then the file does not adhere
                // to Sabre's 'unique record' specifications
                
                uniqueRecords.add(record);
                
            });
                
        return uniqueRecords;
    }
    
    /*
     * Removes duplicate PNR records based on the equals() method defined in each PNR file class.
     * Amongst the duplicate records, the one with the latest FromDateTime is kept.
     */
    public static Set<? extends PNRRecord> removeDuplicatePNRRecords(List<PNRRecord> pnrRecords) {
    	
        final Set<PNRRecord> uniqueRecords = new HashSet<>();
        
        pnrRecords.stream()
            .sorted(new Comparator<PNRRecord>() {
                @Override
                public int compare(PNRRecord lhs, PNRRecord rhs) {
                    // most up to date is top of the list
                    // this is important because it is the first element that is
                    // added to the 'uniques' set
                    if (lhs.getPNRLocatorID().compareTo(rhs.getPNRLocatorID()) == 0) {
                        if (lhs.getPNRCreateDate().compareTo(rhs.getPNRCreateDate()) == 0) {
                            return DESCENDING * (lhs.getFromDateTime().compareTo(rhs.getFromDateTime()));
                        }
                        else return DESCENDING * (lhs.getPNRCreateDate().compareTo(rhs.getPNRCreateDate()));
                    }
                    else return DESCENDING * (lhs.getPNRLocatorID().compareTo(rhs.getPNRLocatorID()));
                }
            })
            .forEachOrdered(record -> {
                // Attempt to add the record to the set of unique records,
                // as defined by its equals() and hashcode() implementation.
                // If the record cannot be added, then the file does not adhere
                // to Sabre's 'unique record' specifications
                
                uniqueRecords.add(record);

            });
                  
         return uniqueRecords;
    }
    
}
