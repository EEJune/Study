#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

int save[2] = { 0,1 };

int main() {
	int size = 0, cnt = 0;
	scanf("%d", &size);
	for (int i = 2;i <=size;i++) {
		save[cnt++ % 2] = save[i%2] + save[(i+1)%2];
	}
	printf("%d", save[(size) % 2]);
}
