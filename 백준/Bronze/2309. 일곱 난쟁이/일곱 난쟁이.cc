#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	int arr[9] = { 0, };
	for (int i = 0; i < 9; i++) {
		std::cin >> arr[i];
	}

	std::sort(arr, arr + 9);

	for (int i = 0; i < 9; i++) {
		for (int j = i + 1; j < 9; j++) {
			int sum = 0;
			for (int k = 0; k < 9; k++) {
				if (k != i && k != j) {
					sum += arr[k];
				}
			}
			if (sum == 100) {
				for (int k = 0; k < 9; k++) {
					if (k != i && k != j) {
						std::cout << arr[k] << "\n";
					}
				}
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