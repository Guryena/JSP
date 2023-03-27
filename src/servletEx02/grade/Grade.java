package servletEx02.grade;

public class Grade {
	private double kor;
	private double eng;
	private double math;
	
	public Grade(double kor, double eng, double math) {
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	public double getSum() {
		double sum = kor + eng + math;
		return sum;
	}
	public double getAvg() {
		double avg = (double) getSum() / 3;
		return avg;
	}
	
	public char getGrade() {
		char grade = '가';
		if (getAvg()>=90) {
			grade = '수';
		}
		else if (getAvg()>=80) {
			grade = '우';
		}
		else if (getAvg()>=70) {
			grade = '미';
		}
		else if (getAvg()>=60) {
			grade = '양';
		}
		return grade;
	}
	
}
