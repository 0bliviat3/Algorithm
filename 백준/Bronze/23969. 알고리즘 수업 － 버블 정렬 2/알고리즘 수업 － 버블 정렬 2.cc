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

	std::vector<int> arr(n);

	for (int i = 0; i < n; ++i) {
		std::cin >> arr[i];
	}

	int change_count = 0;

	for (int i = n - 1; i > 0; i--) {
		for (int j = 0; j < i; j++) {
			if (arr[j] > arr[j + 1]) {
				std::swap(arr[j], arr[j + 1]);
				change_count++;
				if (change_count == k) {
					for (int i = 0; i < n; ++i) {
						std::cout << arr[i] << " ";
					}
					return;
				}
			}
		}
	}

	std::cout << -1 << "\n";
	

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}