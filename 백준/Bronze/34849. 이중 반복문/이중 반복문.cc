#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>


void solve() {

	long long n;
	std::cin >> n;

	if (n * n <= 100000000) {
		std::cout << "Accepted";
	} else {
		std::cout << "Time limit exceeded";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}