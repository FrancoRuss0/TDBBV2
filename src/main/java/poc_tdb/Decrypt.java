package poc_tdb;


	import org.bouncycastle.openpgp.*;
	import org.bouncycastle.openpgp.operator.jcajce.*;

	import java.io.*;
	import java.util.Iterator;
	import java.io.BufferedInputStream;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.security.Security;

	import org.bouncycastle.jce.provider.BouncyCastleProvider;
	import org.bouncycastle.openpgp.PGPCompressedData;
	import org.bouncycastle.openpgp.PGPEncryptedDataList;
	import org.bouncycastle.openpgp.PGPException;
	import org.bouncycastle.openpgp.PGPLiteralData;
	import org.bouncycastle.openpgp.PGPPBEEncryptedData;
	import org.bouncycastle.openpgp.PGPUtil;
	import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
	import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
	import org.bouncycastle.openpgp.operator.jcajce.JcePBEDataDecryptorFactoryBuilder;
	import org.bouncycastle.util.io.Streams;

	public class Decrypt {


	    
	    static PGPPublicKey readPublicKey(String fileName) throws IOException, PGPException
	    {
	        InputStream keyIn = new BufferedInputStream(new FileInputStream(fileName));
	        PGPPublicKey pubKey = readPublicKey(keyIn);
	        keyIn.close();
	        return pubKey;
	    }

	    /**
	     * A simple routine that opens a key ring file and loads the first available key
	     * suitable for encryption.
	     * 
	     * @param input data stream containing the public key data
	     * @return the first public key found.
	     * @throws IOException
	     * @throws PGPException
	     */
	    static PGPPublicKey readPublicKey(InputStream input) throws IOException, PGPException
	    {
	        PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(
	            PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());

	        //
	        // we just loop through the collection till we find a key suitable for encryption, in the real
	        // world you would probably want to be a bit smarter about this.
	        //

	        Iterator keyRingIter = pgpPub.getKeyRings();
	        while (keyRingIter.hasNext())
	        {
	            PGPPublicKeyRing keyRing = (PGPPublicKeyRing)keyRingIter.next();

	            Iterator keyIter = keyRing.getPublicKeys();
	            while (keyIter.hasNext())
	            {
	                PGPPublicKey key = (PGPPublicKey)keyIter.next();

	                if (key.isEncryptionKey())
	                {
	                    return key;
	                }
	            }
	        }

	        throw new IllegalArgumentException("Can't find encryption key in key ring.");
	    }

	    static PGPSecretKey readSecretKey(String fileName) throws IOException, PGPException
	    {
	        InputStream keyIn = new BufferedInputStream(new FileInputStream(fileName));
	        PGPSecretKey secKey = readSecretKey(keyIn);
	        keyIn.close();
	        return secKey;
	    }

	    /**
	     * A simple routine that opens a key ring file and loads the first available key
	     * suitable for signature generation.
	     * 
	     * @param input stream to read the secret key ring collection from.
	     * @return a secret key.
	     * @throws IOException on a problem with using the input stream.
	     * @throws PGPException if there is an issue parsing the input stream.
	     */
	    static PGPSecretKey readSecretKey(InputStream input) throws IOException, PGPException
	    {
	        PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(
	            PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());

	        //
	        // we just loop through the collection till we find a key suitable for encryption, in the real
	        // world you would probably want to be a bit smarter about this.
	        //

	        Iterator keyRingIter = pgpSec.getKeyRings();
	        while (keyRingIter.hasNext())
	        {
	            PGPSecretKeyRing keyRing = (PGPSecretKeyRing)keyRingIter.next();

	            Iterator keyIter = keyRing.getSecretKeys();
	            while (keyIter.hasNext())
	            {
	                PGPSecretKey key = (PGPSecretKey)keyIter.next();

	                if (key.isSigningKey())
	                {
	                    return key;
	                }
	            }
	        }

	        throw new IllegalArgumentException("Can't find signing key in key ring.");
	    }

	    public static byte[] decryptFile(String inputFileName, char[] passPhrase)  throws IOException, PGPException
	    {
	        InputStream in = new BufferedInputStream(new FileInputStream(inputFileName));
	        byte[] prova = decryptFile(in, passPhrase);
	        in.close();
			return prova;
			
	    }
	    private static byte[] decryptFile(InputStream in, char[] passPhrase) throws IOException, PGPException {
	        in = PGPUtil.getDecoderStream(in);
	        Security.addProvider(new BouncyCastleProvider());
	        JcaPGPObjectFactory pgpF = new JcaPGPObjectFactory(in);
	        PGPEncryptedDataList enc;
	        Object o = pgpF.nextObject();

	        // Il primo oggetto potrebbe essere un PGP marker packet.
	        if (o instanceof PGPEncryptedDataList) {
	            enc = (PGPEncryptedDataList) o;
	        } else {
	            enc = (PGPEncryptedDataList) pgpF.nextObject();
	        }

	        // Verifica se i dati sono cifrati con passphrase (PBE) o con chiave pubblica
	        if (enc.get(0) instanceof PGPPBEEncryptedData) {
	            // Gestisci la cifratura basata su passphrase
	            PGPPBEEncryptedData pbe = (PGPPBEEncryptedData) enc.get(0);
	            

	            if (!pbe.isIntegrityProtected()) {
	                throw new PGPException("Il messaggio non è protetto da integrità!");
	            }

	            // Creazione del decryptor per passphrase
	            JcePBEDataDecryptorFactoryBuilder decryptorFactoryBuilder = new JcePBEDataDecryptorFactoryBuilder(
	                    new JcaPGPDigestCalculatorProviderBuilder().setProvider("BC").build())
	                    .setProvider("BC");
	            
	            // Decrypt dei dati cifrati con passphrase
	            InputStream clear = pbe.getDataStream(decryptorFactoryBuilder.build(passPhrase));
	            pgpF = new JcaPGPObjectFactory(clear);

	            o = pgpF.nextObject();

	            // Gestione della compressione dei dati
	            if (o instanceof PGPCompressedData) {
	                PGPCompressedData cData = (PGPCompressedData) o;
	                pgpF = new JcaPGPObjectFactory(cData.getDataStream());
	                o = pgpF.nextObject();
	            }

	            // Lettura dei dati letterali (dati non cifrati)
	            PGPLiteralData ld = (PGPLiteralData) o;
	            InputStream unc = ld.getInputStream();
	            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    	    Streams.pipeAll(unc, byteArrayOutputStream, 8888192);
	    	    byte[] decryptedData = byteArrayOutputStream.toByteArray();

	            // Verifica dell'integrità del messaggio
	            if (!pbe.verify()) {
	                System.err.println("Il messaggio ha fallito il controllo di integrità.");
	            } else {
	                System.err.println("Il controllo di integrità del messaggio è stato superato.");
	            }

	       return decryptedData; 
	       } else if (enc.get(0) instanceof PGPPublicKeyEncryptedData) {
	    	    // Gestisci la cifratura con chiave pubblica
	    	    PGPPublicKeyEncryptedData pubKeyEncData = (PGPPublicKeyEncryptedData) enc.get(0);

	    	    if (!pubKeyEncData.isIntegrityProtected()) {
	    	        throw new PGPException("Il messaggio non è protetto da integrità!");
	    	    }

	    	    // Carica la chiave privata (devi averla in un file o in una chiave segreta)
	    	    // Assicurati di aver caricato la chiave privata con la passphrase
	    	    PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(
	    	        PGPUtil.getDecoderStream(new FileInputStream("src/main/resources/secring.gpg")), 
	    	        new JcaKeyFingerprintCalculator()
	    	    );

	    	    Iterator keyRingIter = pgpSec.getKeyRings();
	    	    PGPPrivateKey privateKey = null;

	    	    while (keyRingIter.hasNext()) {
	    	        PGPSecretKeyRing keyRing = (PGPSecretKeyRing) keyRingIter.next();
	    	        Iterator keyIter = keyRing.getSecretKeys();
	    	        while (keyIter.hasNext()) {
	    	            PGPSecretKey secretKey = (PGPSecretKey) keyIter.next();
	    	            if (secretKey.getPublicKey().getKeyID() == pubKeyEncData.getKeyID()) {
	    	                privateKey = secretKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build(passPhrase));
	    	                break;
	    	            }
	    	        }
	    	        if (privateKey != null) {
	    	            break; // Abbiamo trovato la chiave privata, quindi esci dal ciclo
	    	        }
	    	    }

	    	    if (privateKey == null) {
	    	        throw new PGPException("Non è stata trovata la chiave privata per la decrittazione.");
	    	    }

	    	    // Usa la chiave privata per decriptare i dati cifrati con chiave pubblica
	    	    InputStream clear = pubKeyEncData.getDataStream(new JcePublicKeyDataDecryptorFactoryBuilder().setProvider("BC").build(privateKey));

	    	    pgpF = new JcaPGPObjectFactory(clear);
	    	    o = pgpF.nextObject();

	    	    // Gestione della compressione dei dati (come nel caso precedente)
	    	    if (o instanceof PGPCompressedData) {
	    	        PGPCompressedData cData = (PGPCompressedData) o;
	    	        pgpF = new JcaPGPObjectFactory(cData.getDataStream());
	    	        o = pgpF.nextObject();
	    	    }

	    	    // Lettura dei dati letterali (dati non cifrati)
	    	    PGPLiteralData ld = (PGPLiteralData) o;
	    	    InputStream unc = ld.getInputStream();
	    	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    	    Streams.pipeAll(unc, byteArrayOutputStream, 8888192);
	    	    byte[] decryptedData = byteArrayOutputStream.toByteArray();


	    	    // Verifica dell'integrità del messaggio
	    	    if (pubKeyEncData.verify()) {
	    	        System.out.println("IL CONTROLLO DI INTEGRITÀ DEL MESSAGGIO È STATO SUPERATO.");

	    	    } else {
	    	    	 System.err.println("Il messaggio ha fallito il controllo di integrità.");
	    	    }

	    	    return decryptedData;  // Restituisci il flusso decrittografato
	    	} else {
	    	    throw new PGPException("Tipo di dati cifrati sconosciuto");
	    	}
			
	    }


}