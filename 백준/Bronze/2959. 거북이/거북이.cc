#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	
	int n = 4;
	std::vector<int> arr(n);
	while (n--) {
		std::cin >> arr[n];
	}
	std::sort(arr.begin(), arr.end());

	std::cout << arr[0] * arr[2];
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}