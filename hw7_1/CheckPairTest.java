
//***************************
// ���ϸ�: CheckPairTest.java
// �ۼ���: �ȼ���
// �ۼ���: 2017.11.02
// ����: ������ �̿��Ͽ� ��ȣ�� �˻��ϴ� ���α׷��� �ۼ��Ͻÿ�.
//***************************
import java.util.Scanner;
public class CheckPairTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw7_1: �ȼ���");
		System.out.println();

		CheckPair pair = new CheckPair();

		String bracket;

		Scanner scan = new Scanner(System.in);
		System.out.println("��ȣ�� �Է�: ");

		bracket = scan.nextLine();

		if(pair.testPair(bracket))
			System.out.println("�ùٸ� ��ȣ���Դϴ�.");
		else
			System.out.println("Ʋ�� ��ȣ���Դϴ�.");
	}

}
