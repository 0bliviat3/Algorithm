#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	while (true) {
		int n;
		std::cin >> n;
		if (!n) {
			break;
		}
		int sum = 0;
		while (n) {
			sum += (n * n);
			n--;
		}
		std::cout << sum << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}