#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;

	bool arr[10][20] = { false, };

	while (n--) {
		char row;
		int col;
		std::cin >> row >> col;
		arr[row - 'A'][col - 1] = true;
	}

	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 20; j++) {
			if (arr[i][j]) {
				std::cout << 'o';
			} else {
				std::cout << '.';
			}
		}
		std::cout << '\n';
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}