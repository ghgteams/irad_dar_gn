package com.irad.dar.punjab.cctns;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.PrivateKey;
import java.security.Security;
import java.util.Collection;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.KeyTransRecipientInformation;
import org.bouncycastle.cms.RecipientInformation;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipient;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;


public class DataSecurityUtil {

	

	public static byte[] decryptData(byte[] encryptedData, PrivateKey decryptionKey) throws Exception {

		byte[] decryptedData = null;
		if (null != encryptedData && null != decryptionKey) {
			CMSEnvelopedData envelopedData = new CMSEnvelopedData(encryptedData);

			Collection<RecipientInformation> recipients = envelopedData.getRecipientInfos().getRecipients();
			KeyTransRecipientInformation recipientInfo = (KeyTransRecipientInformation) recipients.iterator().next();
			JceKeyTransRecipient recipient = new JceKeyTransEnvelopedRecipient(decryptionKey);

			return recipientInfo.getContent(recipient);
		}
		return decryptedData;
	}
	
	public static PrivateKey pemLoadKeyTest() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream res = classloader.getResourceAsStream("irad_key.pem"); //pvt cctns key
		Reader fRd = new BufferedReader(new InputStreamReader(res));
		PEMParser pemParser = new PEMParser(fRd);
		Object object = pemParser.readObject();
		JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
		PrivateKeyInfo ukp = (PrivateKeyInfo) object;
		PrivateKey pk = converter.getPrivateKey(ukp);
		pemParser.close();
		return pk;

	}
	
//	/cctns_decryption/src/main/java/com/example/key/irad_cert.pem
//	
//	/cctns_decryption/src/main/java/com/example/security/DataSecurityUtil.java
}
