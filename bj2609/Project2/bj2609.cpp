#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
using namespace std;

/*int main(void) {
	int num1, num2, min;
	cin >> num1 >> num2;
	min = num1;
	while (min % num2 != 0)
		min += num1;
	cout << (num1 * num2) / min << endl;
	cout << min;
}*/
//�ּ� ������� �ִ� ������� ã�� ����̴�.
//�ٸ� ���μ� ���� ex) 11, 37�� ��� 11�� 37�� ���ϰų� 37�� 11�� �� �� �� ���� �ִ� ������� ���� �� ����
//�� ������ ������ �ƴϴ�. �̸� �ְ�� �ذ��Ϸ��� ��Ŭ���� ȣ�������� �ִ� ������� ���� �� �ּ� ������� ���ϴ°� �ξ� ������
int gcd(int num1, int num2)
{
	while (num2 != 0) {
		int tmp = num2;
		num2 = num1 % num2;
		num1 = tmp;
	}
	return num1;
}
int main(void) {
	int num1, num2, max;
	cin >> num1 >> num2;
	if (num2 > num1)
	{
		int tmp = num2;
		num2 = num1;
		num1 = tmp;
	}
	max = gcd(num1, num2);
	cout << max << endl;
	cout << (num1 * num2) / max;
}