package poc_tdb;

import java.util.ArrayList;
import java.util.Iterator;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

public class PreprocessTdbBatchSubflow {

	static ArrayList<DoneFileEntry> parentModels = new ArrayList<>();

	public static void setParentModel(ArrayList<DoneFileEntry> doneFileEntryList) {
		for (DoneFileEntry entry : doneFileEntryList) {
			if (entry.getFilename().equals("Res")) {
				parentModels.add(entry);
			} else if (entry.getFilename().equals("TktDocument")) {
				parentModels.add(entry);
			}
		}
		System.out.println(parentModels);
	}

	public static void processRes(ArrayList<DoneFileEntry> parentModels) {
		// TODO one-iteration-over-done-file-entry-privateflow(parentModels[0])

	}

	public static void processTktDocument(ArrayList<DoneFileEntry> parentModels) {
		// TODO one-iteration-over-done-file-entry-privateflow(parentModels[1])
		
	}

	public static ArrayList<DoneFileEntry> process(ArrayList<DoneFileEntry> doneFileEntryList) {
		setParentModel(doneFileEntryList);
		processRes(parentModels);
		processTktDocument(parentModels);
		Iterator<DoneFileEntry> iterator = doneFileEntryList.iterator();
		while (iterator.hasNext()) {
			DoneFileEntry entry = iterator.next();
			if (entry.getFilename().equals("Res") || entry.getFilename().equals("TktDocument")) {
				iterator.remove();
			}
		}
		return doneFileEntryList;

	}
}
