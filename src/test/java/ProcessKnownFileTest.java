import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.LoadDatFileIntoPojo;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.SqlQueries;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.TransformationIntoPOJO;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;
import com.kmmaltairlines.hip.tdbingester.utils.UtilityTest;
import com.kmmaltairlines.mail.EmailRequest;
import com.kmmaltairlines.mail.MailService;

class ProcessKnownFileTest {
	
	@Test
	public void processKnownFileTest() throws Exception {
		// Mock delle dipendenze di LoadDatFileIntoPojo
		TransformationIntoPOJO transformation = mock(TransformationIntoPOJO.class);
		Utility utility = mock(Utility.class);
		SqlQueries query = mock(SqlQueries.class);
		MailService mailService = mock(MailService.class);
		EmailRequest emailRequest = mock(EmailRequest.class);
		Connection connection = mock(Connection.class);

		// Creazione dell'istanza di LoadDatFileIntoPojo e iniezione delle dipendenze
		// mockate
		LoadDatFileIntoPojo load = new LoadDatFileIntoPojo();
		load.transformation = transformation;
		load.utility = utility;
		load.query = query;
		load.mailService = mailService;
		load.emailRequest = emailRequest;

		ArrayList<DoneFileEntry> doneFileEntry = new ArrayList<DoneFileEntry>();
		DoneFileEntry FileEntry= new DoneFileEntry("Res",1);
		doneFileEntry.add(FileEntry);
		DoneFile doneFile= UtilityTest.setDoneFile();
		
		
		// Chiamata al metodo da testare
		load.loadDatFile(FileEntry.getFilename(), doneFile.getFileEntries().toString() , doneFileEntry , connection, doneFile.getFileName());

		verify(transformation, times(1)).loadDatFileIntoPOJO(doneFile.getFileEntries().toString(),FileEntry.getFilename());
	}
}