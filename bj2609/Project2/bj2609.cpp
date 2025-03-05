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
//최소 공배수로 최대 공약수를 찾는 방식이다.
//다만 소인수 끼리 ex) 11, 37의 경우 11을 37번 더하거나 37을 11번 더 할 때 까지 최대 공약수를 구할 수 없다
//즉 최적의 로직이 아니다. 이를 최고로 해결하려면 유클리드 호제법으로 최대 공약수를 구한 후 최소 공배수를 구하는게 훨씬 빠르다
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