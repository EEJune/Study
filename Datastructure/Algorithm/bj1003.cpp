#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
int cnt = 0;

int main() {
	int save[2][2] = { {1,0},{0,1} };
	int run;
	scanf("%d", &run);
	int* repeat = (int*)malloc(sizeof(int)*run);
	for (int i = 0;i < run;i++) {
		scanf("%d", &repeat[i]);
	}
	for (int i = 0;i < run;i++) {
		for (int j = 2;j <= repeat[i];j++) {
			save[cnt % 2][0] = save[0][0] + save[1][0];
			save[cnt % 2][1] = save[0][1] + save[1][1];
			cnt++;
		}
		printf("%d %d\n", save[repeat[i] % 2][0], save[repeat[i] % 2][1]);
		save[0][0] = 1;
		save[0][1] = 0;
		save[1][0] = 0;
		save[1][1] = 1;
		cnt = 0;
	}
}
