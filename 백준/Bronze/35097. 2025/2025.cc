#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	while (true) {
		int n;
		std::cin >> n;
		if (n == 0) break;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum += (i * j);
				
			}
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