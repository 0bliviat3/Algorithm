#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

int isSqrtTwo(int n) {
	return (n & (n * -1)) == n;
}

void solve() {

	int n;
	std::cin >> n;
	while (n--) {
		int now;
		std::cin >> now;
		std::cout << isSqrtTwo(now) << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}