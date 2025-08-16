#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;

	int start = 0;
	bool flag = true;
	while (n--) {
		int now;
		std::cin >> now;
		start++;
		while (now != start) {
			flag = false;
			std::cout << start++ << "\n";
		}
	}
	if (flag) {
		std::cout << "good job";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}