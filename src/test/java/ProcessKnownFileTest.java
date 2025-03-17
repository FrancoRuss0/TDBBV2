import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.LoadDatFileIntoPojo;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.SqlQueries;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.TransformationIntoPOJO;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;
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

        // Configurazione del mock TransformationIntoPOJO
        ArrayList<Object> transformedList = new ArrayList<>();
        transformedList.add(new Object());
        when(transformation.loadDatFileIntoPOJO(anyString(), anyString())).thenReturn(transformedList);
        // Configurazione del mock Utility
        when(utility.getRecordsByFilename(anyString(), any())).thenReturn(transformedList.size());

        // Creazione dell'istanza di LoadDatFileIntoPojo e iniezione delle dipendenze mockate
        LoadDatFileIntoPojo load = new LoadDatFileIntoPojo();
        load.transformation = transformation;
        load.utility = utility;
        load.query = query;
        load.mailService = mailService;
        load.emailRequest = emailRequest;

        // Dati di test
        String baseFilename = "Res";
        String doneFileEntryValue = "testData";
        ArrayList<DoneFileEntry> dotFiles = new ArrayList<>();
        // Aggiungi DoneFileEntry con "Res" e 1
        DoneFileEntry resEntry = new DoneFileEntry("Res", 1);
        dotFiles.add(resEntry);
        String encFileName = "encryptedFile";

        // Chiamata al metodo da testare
        boolean result = load.loadDatFile(baseFilename, doneFileEntryValue, dotFiles, connection, encFileName);

        // Verifiche
        assertTrue(result);
        verify(transformation).loadDatFileIntoPOJO(doneFileEntryValue, baseFilename);
        verify(utility).getRecordsByFilename(baseFilename, dotFiles);
        verify(query).sql(transformedList, baseFilename, connection);
    }
}