/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 *
 */
public class EncodeAndDecodeTinyURL {
	private char[] charSet = new char[62];
	private HashMap<String, String> urlMap = new HashMap<>();

	public Codec() {
		addCharSource('0', '9', 0);
		addCharSource('a', 'z', 10);
		addCharSource('A', 'Z', 36);
	}

	private void addCharSource(char start, char end, int index) {
		for(char c=start; c<=end; c++) {
			this.charSet[index++] = c;
		}
	}

	private String generateKey() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();

		for(int i=0; i<6; i++) {
			sb.append(this.charSet[rand.nextInt(62)]);
		}

		return sb.toString();
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String shortUrl = "http://tinyurl.com/"+ this.generateKey();
		while(urlMap.containsKey(shortUrl)) {
			shortUrl = "http://tinyurl.com/"+ this.generateKey();
		}
		urlMap.put(shortUrl, longUrl);
		return shortUrl;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		if(urlMap.containsKey(shortUrl)) {
			return urlMap.get(shortUrl);
		}
		return "";
	}
}
