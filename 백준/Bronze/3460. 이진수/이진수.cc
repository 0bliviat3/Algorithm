#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

std::vector<bool> convertBinary(int num) {
	std::vector<bool> arr;
	while (num) {
		arr.push_back(num % 2);
		num /= 2;
	}
	return arr;
}

void solve() {

	int t;
	std::cin >> t;
	while (t--) {
		int n;
		std::cin >> n;
		std::vector<bool> arr = convertBinary(n);
		for (int i = 0; i < arr.size(); i++) {
			if (arr[i]) std::cout << i << ' ';
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