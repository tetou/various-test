package mail.tools;

public class Util{
	/**
	 * Unicode•¶Žš—ñ‚É•ÏŠ·‚·‚é("‚ " -> "\u3042")
	 * @param original
	 * @return
	 */
	public static String convertToUnicode(String original)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < original.length(); i++) {
			sb.append(String.format("\\u%04X", Character.codePointAt(original, i)));
		}
		return sb.toString();
	}
}