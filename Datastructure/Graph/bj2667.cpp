#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include<algorithm>
using namespace std;

vector<int>	ve;
int cnt = 1;

bool Ex(int dx,int dy,int size) {
	if (dx<0 || dy<0 || dx>=size || dy>=size) return false;
	else return true;
}
void DFS(int **arr,int y,int x,int size,short**visited) {
	int DI[4][2] = { {1,0},{-1,0},{0,-1},{0,1}};
	visited[y][x] = 1;
	for (int k = 0;k < 4;k++) {
		int dy = y + DI[k][1];
		int dx = x + DI[k][0];
		if (Ex(dy, dx, size)) {
			if (arr[dy][dx] == 1 && visited[dy][dx]==0) {
				cnt++;
				DFS(arr, dy, dx, size,visited);
			}
		}
	}
}

void sorted() {
	for (int i = 0;i < ve.size()-1;i++) {
		int min = ve[i];
		for (int j = i+1;j < ve.size();j++) {
			if (ve[i] > ve[j]) {
				min = ve[i];
				ve[i] = ve[j];
				ve[j] = min;
			}
		}
	}
}

int main() {
	int size,num;
	scanf("%d", &size);
	int** arr = (int**)malloc(sizeof(int*) * size);
	short** visited =(short**)malloc(sizeof(short*) * size);
	for (int i = 0;i < size;i++) {
		arr[i] = (int*)malloc(sizeof(int) * size);
		visited[i] = (short*)malloc(sizeof(short) * size);
		for (int j = 0;j < size;j++) {
			scanf("%1d",&arr[i][j]);
			visited[i][j] = 0;
		}
	}
	for (int i = 0;i < size;i++) {
		for (int j = 0;j < size;j++) {
			if (visited[i][j]==0 && arr[i][j] == 1) {
				DFS(arr,i, j,size,visited);
				ve.push_back(cnt);
				cnt = 1;
			}
		}
	}
	sorted();
	cout << ve.size() << endl;
	for (int i = 0;i < ve.size();i++) cout << ve[i] << endl;
}

