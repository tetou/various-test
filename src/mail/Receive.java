package mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import mail.entity.Mail;
import mail.entity.Utility;

public class Receive{
	
	public static final Pattern fromHeaderParsePattern = Pattern.compile("^[\"0-9a-zA-Z\\.\\s]+<([0-9a-zA-Z\\.]+@[0-9a-zA-Z\\.]+)>$");
	
	public static Mail processFromFile(File file,String charset){
		try {
			InputStream is = new FileInputStream(file);
			Session session = Session.getDefaultInstance(new Properties(),null);
			MimeMessage mimeMessage = new MimeMessage(session,is);
			Object content = Utility.getContentOf(mimeMessage, charset);
			Address[] addrs = mimeMessage.getAllRecipients();
			String addrsStr = "";
			for (Address ad:addrs){
				addrsStr += ad.toString() +",";
			}
			addrsStr = addrsStr.replaceAll(",$", "");
			String fromStr = "";
			for (String fr:mimeMessage.getHeader("From")){
				Matcher mt = fromHeaderParsePattern.matcher(fr);
				if (mt.lookingAt() && mt.group(1)!=null) fromStr += mt.group(1) +",";
			}
			fromStr = fromStr.replaceAll(",$", "");
			return new Mail(addrsStr,fromStr,mimeMessage.getSubject(),content.toString());
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {}
	}
}