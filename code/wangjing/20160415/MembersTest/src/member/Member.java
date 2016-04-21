package member;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Member {

	public String memberName;
	public String memberEmail;
	public String memberPasswd;

	public Member() {
	}

	public Member(String memberStr) {

	}

	public Member(String memberName, String memberEmail, String memberPasswd) {
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPasswd = memberPasswd;
	}

	/***
	 * @return ���Ÿ�������,����,����
	 */
	public String toString() {
		return String.format("%S,%s,%s", this.memberName, this.memberEmail,
				this.memberPasswd);

	}

	/**
	 * ����û�
	 * 
	 * @param fileName
	 *            �浵�ļ���
	 * @param memberStr
	 * 
	 */
	public static String MemberInsert(String fileName, String memberStr) {

		try {
			FileOutputStream fos = new FileOutputStream(fileName, true); // append=true
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			osw.write(memberStr + "\r\n");

			osw.flush();
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

	}

	private static Map<String, Member> LoadMemberList(String fileName)
			throws IOException {

		Map<String, Member> ret = new HashMap<String, Member>();

		try {

			InputStreamReader isr = new InputStreamReader(new FileInputStream(
					fileName), "UTF-8");

			StringBuffer sbread = new StringBuffer();

			BufferedReader reader = new BufferedReader(isr);

			String line = reader.readLine();

			while (line!=null) {

				System.out.println(line);

				String[] m = line.split(",");
				Member aMember = new Member(m[0], m[1], m[2]);
				ret.put(aMember.memberEmail, aMember);
				line = reader.readLine();
			}

		}

		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		return ret;
	}

	 
	/**
	 * 
	 * @param fileName
	 *            �浵�ļ���
	 * @param queryFilter
	 *            �������� �����ʡ��û����� �ֶηǿ�ʱ������Ч
	 * @return ���ط��������ļ�¼����
	 * @throws IOException
	 */
	public static ArrayList<Member> QueryMembers (String fileName, Member queryFilter)
			throws IOException {

		ArrayList<Member> ret = new ArrayList<Member>();

		Map<String, Member> allList =  LoadMemberList(fileName);

		Set<String> keys = allList.keySet();

		for (String key : keys) {
			if (!queryFilter.memberEmail.equals("") // �������������˵��ʣ��Ҹ�����¼�ĵ��ʲ�ƥ��������
					&& !allList.get(key).memberEmail
							.equals(queryFilter.memberEmail)) {
				continue;
			}

			if (!queryFilter.memberName.equals("") // �������������˵��ʣ��Ҹ�����¼�ĵ��ʲ�ƥ��������
					&& !allList.get(key).memberName
							.equals(queryFilter.memberName)) {
				continue;
			}

			ret.add(allList.get(key));

		}

		return ret;

	}

	/**
	 * ��������Ƿ񲻴���
	 * 
	 * @param memberEmail
	 *            ���������
	 * @return
	 * @throws Exception
	 */
	public boolean CheckEmailNoneExist(String memberEmail) {

		try {
			Map<String, Member> memberList = this.LoadMemberList("MemberDB.txt");

			return memberList.get(memberEmail).equals(null);
		} catch (Exception e) {
		}
		return true;

	}

	/***
	 * ��������Ƿ�Ϲ�
	 * 
	 * @param memberEmail
	 * @return
	 */
	public boolean CheckEmailValid(String memberEmail) {
		if (!memberEmail.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			return false;
		} else
			return true;

	}
}
