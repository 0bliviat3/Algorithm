#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	

	int n;
	std::cin >> n;

	std::vector<int> arr;

	int max = 0;
	int min = 1001;

	while (n--) {
		int now;
		std::cin >> now;
		arr.push_back(now);
		if (now > max) max = now;
		if (now < min) min = now;
	}

	if (min == arr[0]) {
		std::cout << "ez";
	} else if (max == arr[0]) {
		std::cout << "hard";
	} else {
		std::cout << "?";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}