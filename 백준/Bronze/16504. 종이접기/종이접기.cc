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
	long long sum = 0;
	for (int i = 0; i < n * n; i++) {
		int now;
		std::cin >> now;
		sum += now;
	}
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}