
//***************************
// 파일명: CheckPairTest.java
// 작성자: 안세연
// 작성일: 2017.11.02
// 설명: 스택을 이용하여 괄호를 검사하는 프로그램을 작성하시오.
//***************************
import java.util.Scanner;
public class CheckPairTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw7_1: 안세연");
		System.out.println();

		CheckPair pair = new CheckPair();

		String bracket;

		Scanner scan = new Scanner(System.in);
		System.out.println("괄호식 입력: ");

		bracket = scan.nextLine();

		if(pair.testPair(bracket))
			System.out.println("올바른 괄호식입니다.");
		else
			System.out.println("틀린 괄호식입니다.");
	}

}
