#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	int arr[5];
	for (int i = 0; i < 5; i++) {
		std::cin >> arr[i];
	}

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 4; j++) {
			if (arr[j] > arr[j + 1]) {
				std::swap(arr[j], arr[j + 1]);
				for (int k = 0; k < 5; k++) {
					std::cout << arr[k] << ' ';
				}
				std::cout << '\n';
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