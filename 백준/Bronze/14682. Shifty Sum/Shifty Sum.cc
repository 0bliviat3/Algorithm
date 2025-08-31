#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int n;
	int k;
	std::cin >> n >> k;

	int sum = n;
	while (k) {
		sum += (n * std::pow(10, k--));
	}

	std::cout << sum;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}