package mail.entity;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

public class Utility {
	  public static Object getContentOf(MimeMessage message, String charset)
	                                    throws MessagingException {
	  Object content = null;
	  DataSourceWrapper sourceT;
	  try {
	    DataSource source = message.getDataHandler().getDataSource();
	    if (source == null) {
	    	sourceT = new DataSourceWrapper(new MimePartDataSource((MimePart) message),charset);
	    } else {
	    	sourceT = new DataSourceWrapper(source,charset);
	    }
	    System.out.println("•ÏŠ·‘O‚ÌContent-Type: " + source.getContentType());
	    System.out.println("•ÏŠ·Œã‚ÌContent-Type: " + sourceT.getContentType());
	    DataHandler dh = new DataHandler(sourceT);
	    content = dh.getContent();
	  } catch (IOException ioe) {
	    throw new MessagingException(ioe.toString(), ioe);
	  } finally {}
	  return content;
	}
}