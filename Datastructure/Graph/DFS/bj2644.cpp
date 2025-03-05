#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include <vector> 
using namespace std;

vector<vector<int>>family(100);
short visited[100];
int cnt[2] = { 0,0 };

void DFS(int p1,int p2) {
	int index = 0;
	int tmp = cnt[0];
	visited[p1] = 1;
	while (1) {
		int parent = family[p1].at(index);
		if (parent == 0) {
			break;
		}
		if (parent == p2) {
			cnt[0]++;
			cnt[1] = cnt[0];
			break;
		}
		if (visited[parent] == 0) {
			visited[parent] = 1;
			cnt[0]++;
			DFS(parent,p2);
			cnt[0]--;
	
		}
		index++;
	}
}
int main() {
	int people=0;
	int p1 = 0, p2 = 0;
	int size = 0;
	int num1=0, num2=0;

	scanf("%d", &people);
	scanf("%d %d", &p1, &p2);
	scanf("%d", &size);
	for (int i = 0;i < size;i++) {
		scanf("%d %d",&num1, &num2);
		family[num1].push_back(num2);
		family[num2].push_back(num1);
	}
	for (int i = 0;i < people+1;i++) {
		family[i].push_back(0);
	}
	DFS(p1, p2);
	if (cnt[1] == 0)printf("-1");
	else printf("%d", cnt[1]);
}
