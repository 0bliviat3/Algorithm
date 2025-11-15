#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;

	bool arr[5] = { false, };
	while (n--) {
		int now;
		std::cin >> now;
		arr[now - 1] = true;
	}

	for (int i = 0; i < 5; i++) {
		if (!arr[i]) {
			std::cout << "YES";
			return;
		}
	}
	std::cout << "NO";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}