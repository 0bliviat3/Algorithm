#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	int n, k;
	std::cin >> n >> k;

	std::vector<std::vector<int>> input(n, std::vector<int>(n));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int now;
			std::cin >> input[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++) {
			for (int l = 0; l < n; l++) {
				int now = input[i][l];
				for (int m = 0; m < k; m++) {
					std::cout << now << " ";
				}
			}
			std::cout << "\n";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}