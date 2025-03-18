package com.kmmaltairlines.hip.tdbingester.processing;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.PNRRecord;
import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtra;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktCoupon;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.filepojos.VCRRecord;

@Component
public class RecordPrunerUtil {
	private static final Logger log = LoggerFactory.getLogger(RecordPrunerUtil.class);

	/**
	 * This method is used to remove VCRs from the payload which are not present in
	 * {@param recordToKeep}.
	 * 
	 * @param payload       This is the list of the records which were parsed from
	 *                      the original input file. The POJO of the record must
	 *                      extend from {@link VCRRecord}, such as
	 *                      {@link TktDocument} or {@link TktCoupon}. This list will
	 *                      be trimmed such that only those records which are
	 *                      present in {@param recordToKeep} are kept.
	 * 
	 * @param recordsToKeep This is the list of new or updated records that should
	 *                      be inserted into the TDB database. The type of this
	 *                      parameter is as follows:
	 * 
	 *                      <pre>
	 *  
	 * Map<String, Map<Date,  List<Map<String, Object>>>>
	 *        ^          ^    ^-----------------------^
	 *        |          |               |
	 *        |          |    The database result set as returned 
	 *        |          |      by Mule's <db:select> processor
	 *        |          |   
	 *        |      The VCRCreateDate.
	 *        |
	 *   The PrimaryDocNbr
	 *
	 *                      </pre>
	 * 
	 *                      The reason why we did not keep the original
	 *                      List<Map<String, Object>> from Mule's database is to
	 *                      avoid List lookups. Changing the List to a Map on the
	 *                      object's equality transforms the lookup of records from
	 *                      O(n) to O(1).
	 * 
	 * @return The original payload with a reduced record set. The resultant record
	 *         set contains only records which are updated VCRs or entirely new
	 *         ones. As such, these must be stored in the database.
	 */
	public static <T extends VCRRecord> List<T> pruneVCRs(final List<T> payload,
			final Map<String, Map<Date, List<Map<String, Object>>>> recordsToKeep) {

		// Don't bother pruning if the TDB file is empty, just return.
		if (payload.isEmpty()) {
			log.info("TDB file is empty. Skipping prune step since there's nothing to prune.");
			return payload;
		}

		int initialPayloadSize = payload.size();

		String vcrClassType = payload.get(0).getClass().getSimpleName();

		log.info("Scanning through {} {} records.", payload.size(), vcrClassType);

		final Iterator<T> iterator = payload.iterator();

		while (iterator.hasNext()) {
			VCRRecord vcr = iterator.next();
			if (recordsToKeep.containsKey(vcr.getPrimaryDocNbr())) {
				Map<Date, List<Map<String, Object>>> innerMap = recordsToKeep.get(vcr.getPrimaryDocNbr());
				if (innerMap.containsKey(vcr.getVCRCreateDate())) {
					log.debug("Keeping VCR record");
				} else
					iterator.remove();
			} else
				iterator.remove();
		}

		int numRemovedRecords = initialPayloadSize - payload.size();
		log.info("{} {} records were kept for insertion. A total of {} records were removed.", payload.size(),
				vcrClassType, numRemovedRecords);

		return payload;
	}

	/**
	 * This method is used to remove PNRs from the payload which are not present in
	 * {@param recordToKeep}.
	 * 
	 * @param payload       This is the list of the records which were parsed from
	 *                      the original input file. The POJO of the record must
	 *                      extend from {@link PNRRecord}, such as
	 *                      {@link ResAddress} or {@link ResAirExtra}. This list
	 *                      will be trimmed such that only those records which are
	 *                      present in {@param recordToKeep} are kept.
	 * 
	 * @param recordsToKeep This is the list of new or updated records that should
	 *                      be inserted into the TDB database. The type of this
	 *                      parameter is as follows:
	 * 
	 *                      <pre>
	 *  
	 * Map<String, Map<Date,  List<Map<String, Object>>>>
	 *        ^          ^    ^-----------------------^
	 *        |          |               |
	 *        |          |    The database result set as returned 
	 *        |          |      by Mule's <db:select> processor
	 *        |          |   
	 *        |      The PNRCreateDate.
	 *        |
	 *   The PNRLocatorID
	 *
	 *                      </pre>
	 * 
	 *                      The reason why we did not keep the original
	 *                      List<Map<String, Object>> from Mule's database is to
	 *                      avoid List lookups. Changing the List to a Map on the
	 *                      object's equality transforms the lookup of records from
	 *                      O(n) to O(1).
	 * 
	 * @return The original payload with a reduced record set. The resultant record
	 *         set contains only records which are updated PNRs or entirely new
	 *         ones. As such, these must be stored in the database.
	 */
	public List<Object> prunePNRs(final List<Object> payload,
			final Map<String, Map<Date, List<Map<String, Object>>>> recordsToKeep) {
// Don't bother pruning if the payload is empty, just return.
		if (payload.isEmpty()) {
			log.info("Payload is empty. Skipping prune step since there's nothing to prune.");
			return payload;
		}

		int initialPayloadSize = payload.size();

		String pnrClassType = payload.get(0).getClass().getSimpleName();

		log.info("Scanning through {} {} records.", payload.size(), pnrClassType);

		final Iterator<Object> iterator = payload.iterator();

		while (iterator.hasNext()) {
			Object obj = iterator.next();

// Controlla che l'oggetto sia effettivamente un'istanza di PNRRecord
			if (obj instanceof PNRRecord) {
				PNRRecord pnr = (PNRRecord) obj;

				if (recordsToKeep.containsKey(pnr.getPNRLocatorID())) {
					Map<Date, List<Map<String, Object>>> innerMap = recordsToKeep.get(pnr.getPNRLocatorID());
					if (innerMap.containsKey(pnr.getPNRCreateDate())) {
						log.debug("Keeping PNR record");
					} else {
						iterator.remove();
					}
				} else {
					iterator.remove();
				}
			} else {
// Se l'oggetto non è un'istanza di PNRRecord, rimuovilo dalla lista
				iterator.remove();
			}
		}

		int numRemovedRecords = initialPayloadSize - payload.size();
		log.info("{} {} records were kept for insertion. A total of {} records were removed.", payload.size(),
				pnrClassType, numRemovedRecords);

		return payload;
	}

}