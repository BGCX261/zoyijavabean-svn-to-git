package org.zoyi.util;
class RC4Test {
	// / <summary>
	// / 用于 RC4 处理密码
	// / </summary>
	// / <param name="pass">密码字串</param>
	// / <param name="kLen">密钥长度，一般为 256</param>
	// / <returns></returns>
	static private byte[] GetKey(byte[] pass, int kLen) {
		byte[] mBox = new byte[kLen];

		for (int i = 0; i < kLen; i++) {
			mBox[i] = (byte) i;
		}

		int j = 0;
		for (int i = 0; i < kLen; i++) {

			j = (j + (int) ((mBox[i] + 256) % 256) + pass[i % pass.length])
					% kLen;

			byte temp = mBox[i];
			mBox[i] = mBox[j];
			mBox[j] = temp;
		}

		return mBox;
	}

	// / <summary>
	// / RC4 原始算法
	// / </summary>
	// / <param name="input">原始字串数组</param>
	// / <param name="pass">密钥</param>
	// / <returns>处理后的字串数组</returns>
	private static byte[] RC4(byte[] input, String pass) {
		if (input == null || pass == null)
			return null;

		byte[] output = new byte[input.length];
		byte[] mBox = GetKey(pass.getBytes(), 256);

		// 加密
		int i = 0;
		int j = 0;

		for (int offset = 0; offset < input.length; offset++) {
			i = (i + 1) % mBox.length;
			j = (j + (int) ((mBox[i] + 256) % 256)) % mBox.length;

			byte temp = mBox[i];
			mBox[i] = mBox[j];
			mBox[j] = temp;
			byte a = input[offset];

			// byte b = mBox[(mBox[i] + mBox[j] % mBox.Length) % mBox.Length];
			// mBox[j] 一定比 mBox.Length 小，不需要在取模
			byte b = mBox[(toInt(mBox[i]) + toInt(mBox[j])) % mBox.length];

			output[offset] = (byte) ((int) a ^ (int) toInt(b));
		}

		return output;
	}

	public static int toInt(byte b) {
		return (int) ((b + 256) % 256);
	}
}