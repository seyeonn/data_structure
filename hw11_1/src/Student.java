
public class Student {
	private int number;
	private int age;

	public Student(int number, int age) {
		this.number = number;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "�й�: " + number + ", ����: " + age ;
	}

}
