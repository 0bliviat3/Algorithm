#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int arr[300] = { 0 };

	for (int i = 0; i < 300; ++i) {
		int j = i + 1;
		arr[i] = j * (j + 1) * (j + 2) / 2;
	}

	for (int i = 1; i < 300; ++i) {
		arr[i] += arr[i - 1];
	}

	int n;
	std::cin >> n;
	
	while (n--) {
		int now;
		std::cin >> now;
		std::cout << arr[now - 1] << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}