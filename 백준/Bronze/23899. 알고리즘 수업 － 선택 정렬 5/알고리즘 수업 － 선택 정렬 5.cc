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

	std::vector<int> arr(n);
	std::vector<int> arr2(n);

	for (int i = 0; i < n; ++i) {
		std::cin >> arr[i];
	}
	for (int i = 0; i < n; ++i) {
		std::cin >> arr2[i];
	}

	bool flag = true;
	for (int k = 0; k < n; k++) {
		if (arr[k] != arr2[k]) {
			flag = false;
			break;
		}
	}
	if (flag) {
		std::cout << 1 << "\n";
		return;
	}

	for (int i = n - 1; i > 0; i--) {
		int max = 0;
		int max_index = 0;
		for (int j = 0; j <= i; j++) {
			if (arr[j] > max) {
				max = arr[j];
				max_index = j;
			}
		}
		if (max_index != i) {
			std::swap(arr[max_index], arr[i]);
		}
		bool flag = true;
		for (int k = 0; k < n; k++) {
			if (arr[k] != arr2[k]) {
				flag = false;
				break;
			}
		}
		if (flag) {
			std::cout << 1 << "\n";
			return;
		}
	}

	std::cout << 0 << "\n";
	

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}