#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n;
	std::cin >> n;

	std::vector<int> scores(n, 0);
	std::vector<int[3]> numbers = std::vector<int[3]>(n);
	for (int i = 0; i < n; i++) {
		std::cin >> numbers[i][0] 
			>> numbers[i][1] 
			>> numbers[i][2];
	}

	for (int i = 0; i < 3; i++) {
		int cnts[101] = { 0, };
		for (int j = 0; j < n; j++) {
			cnts[numbers[j][i]]++;
		}
		for (int j = 0; j < n; j++) {
			if (cnts[numbers[j][i]] == 1) {
				scores[j] += numbers[j][i];
			}
		}
	}
	for (int i = 0; i < n; i++) {
		std::cout << scores[i] << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}