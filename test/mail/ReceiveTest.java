package mail;

import java.io.File;

import junit.framework.Assert;
import mail.entity.Mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReceiveTest {
	
	private String expectedContent;

	@Before
	public void setUp() throws Exception {
		this.expectedContent = "メールのテストです。\r\nend。";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testProcessFromFileJIS() {
		File file = new File("test/mail/ISO_2022_JP.txt");
		Mail result = Receive.processFromFile(file, "ISO-2022-JP");
		Assert.assertEquals("toaddress@hogehoge.jp", result.getTos());
		Assert.assertEquals("fromaddress@hogehoge.com", result.getFrom());
		Assert.assertEquals("テストメール！", result.getSubject());
		Assert.assertEquals(expectedContent, result.getContent());
		//System.out.println(result.getContent());
	}
	
	@Test
	public void testProcessFromFileSJIS() {
		File file = new File("test/mail/SJIS.txt");
		Mail result = Receive.processFromFile(file, "Shift_JIS");
		Assert.assertEquals("toaddress@hogehoge.jp", result.getTos());
		Assert.assertEquals("fromaddress@hogehoge.com", result.getFrom());
		Assert.assertEquals("テストメール！", result.getSubject());
		Assert.assertEquals(expectedContent, result.getContent());
		//System.out.println(result.getContent());
	}
	
	@Test
	public void testProcessFromFileEUCJP() {
		File file = new File("test/mail/EUC_JP.txt");
		Mail result = Receive.processFromFile(file, "EUC-JP");
		Assert.assertEquals("toaddress@hogehoge.jp", result.getTos());
		Assert.assertEquals("fromaddress@hogehoge.com", result.getFrom());
		Assert.assertEquals("テストメール！", result.getSubject());
		Assert.assertEquals(expectedContent, result.getContent());
		//System.out.println(result.getContent());
	}

	@Test
	public void testProcessFromFileUTF8() {
		File file = new File("test/mail/UTF8.txt");
		Mail result = Receive.processFromFile(file, "UTF-8");
		Assert.assertEquals("toaddress@hogehoge.jp", result.getTos());
		Assert.assertEquals("fromaddress@hogehoge.com", result.getFrom());
		Assert.assertEquals("テストメール！", result.getSubject());
		Assert.assertEquals(expectedContent, result.getContent());
		//System.out.println(result.getContent());
	}

}
