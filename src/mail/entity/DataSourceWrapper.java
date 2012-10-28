package mail.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class DataSourceWrapper implements DataSource {
  private String contentType;
  private DataSource dataSource;
  private String defaultCharset;

  public DataSourceWrapper(DataSource source, String charset) {
    this.dataSource = source;
    this.defaultCharset = charset;
  }

  public String getContentType() {
    if (contentType == null) {
    	//‚à‚Æ‚à‚Æ‚ÌContent-Type‚ðŽæ“¾
    	String ctype = dataSource.getContentType();
    	if (ctype == null) {
    		ctype = "text/plain";
    	}
    	String lower = ctype.toLowerCase();
    	if (lower.equals("text")) {
    		ctype = "text/plain";
    	}
    	if (lower.indexOf("charset") == -1) {
    		contentType = ctype + "; charset=" + defaultCharset +"";
    	} else {
    		contentType = ctype;
    	}
    }
    return contentType;
  }

  public InputStream getInputStream() throws IOException {
    return dataSource.getInputStream();
  }

  public OutputStream getOutputStream() throws IOException {
    return dataSource.getOutputStream();
  }
  public String getName() {
    return dataSource.getName();
  }

}