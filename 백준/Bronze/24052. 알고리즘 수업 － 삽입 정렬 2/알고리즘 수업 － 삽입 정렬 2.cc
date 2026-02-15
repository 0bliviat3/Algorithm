#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void print_vector(const std::vector<int>& vec) {
	for (const auto& item : vec) {
		std::cout << item << " ";
	}
	std::cout << "\n";
}

void solve() {

	int n, k;

	std::cin >> n >> k;

	std::vector<int> arr(n);

	for (int i = 0; i < n; ++i) {
		std::cin >> arr[i];
	}

	int change_count = 0;

	for (int i = 1; i < n; i++) {
		int loc = i - 1;
		int newItem = arr[i];
		while (loc >= 0 && arr[loc] > newItem) {
			arr[loc + 1] = arr[loc];
			loc--;
			change_count++;
			if (change_count == k) {
				print_vector(arr);
				return;
			}
		}
		if (loc + 1 != i) {
			arr[loc + 1] = newItem;
			change_count++;
			if (change_count == k) {
				print_vector(arr);
				return;
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