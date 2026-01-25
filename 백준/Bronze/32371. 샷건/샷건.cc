#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	char arr[4][10] = { 0, };
	bool ascii[128] = { false, };
	for (int i = 0; i < 4; ++i) {
		for (int j = 0; j < 10; ++j) {
			std::cin >> arr[i][j];
		}
	}

	for (int i = 0; i < 9; i++) {
		char now;
		std::cin >> now;
		ascii[(int)now] = true;
	}

	for (int i = 1; i < 3; i++) {
		for (int j = 1; j < 9; j++) {
			bool flag = true;
			for (int k = i - 1; k <= i + 1; k++) {
				for (int l = j - 1; l <= j + 1; l++) {
					if (!ascii[(int)arr[k][l]]) {
						flag = false;
						break;
					}
				}
				if (!flag) {
					break;
				}
			}
			if (flag) {
				std::cout << arr[i][j];
				return;
			}
		}
	}



}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}